package com.chandra.pos.web.purchase.action;

import com.chandra.pos.EntityNotFoundException;
import com.chandra.pos.dao.entity.*;
import com.chandra.pos.model.OrderFilter;
import com.chandra.pos.model.OrderStatus;
import com.chandra.pos.model.OrderType;
import com.chandra.pos.model.PaymentType;
import com.chandra.pos.security.UserDetailsImpl;
import com.chandra.pos.web.CRUDAction;
import com.chandra.pos.web.OrderActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.security.core.context.SecurityContextHolder;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * UserEntity: root
 * Date: 6/4/12
 * Time: 11:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class PurchaseAction extends OrderActionSupport implements SessionAware, CRUDAction {


    private OrderEntity orderEntity;

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    @Override
    public String doHome() {
        OrderFilter orderFilter = new OrderFilter(0, 10);
        orderFilter.setOrderType(OrderType.PURCHASE);

        DateTime date = new DateTime().toDateMidnight().toDateTime();
        DateTime tomorrow = date.plusDays(1);

        orderFilter.setStartDate(date.toDate());
        orderFilter.setEndDate(tomorrow.toDate());
        orderFilter.setOrderType(OrderType.PURCHASE);
        loadOrders(orderFilter);



        return SUCCESS;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public String doNew() {

        this.orderEntity = (OrderEntity) getSession().get("purchaseEntity");

        if (this.orderEntity == null) {
            this.orderEntity = new OrderEntity();
            orderEntity.setId(-1);
            orderEntity.setOrderType(OrderType.PURCHASE);
            getSession().put("purchaseEntity", orderEntity);

        }
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetailsImpl) {

            orderEntity.setEmployee(((UserDetailsImpl) principal).getUser());
        }


        return INPUT;
    }

    public String doSave() {

        return SUCCESS;
    }

    @Override
    public String doSearch() {
        return SUCCESS;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public String doEdit() {

        return SUCCESS;
    }

    public String doUpdate() {

        getOrderManagement().updateOrder(this.orderEntity);
        return SUCCESS;
    }

    public String doList() {
        Date startDateParam = null, endDatePram = null;


              if (getDateFilterType() == 0) {
                  if (getDateRange() == 0) {//today
                      DateTime date = new DateTime().toDateMidnight().toDateTime();
                      DateTime tomorrow = date.plusDays(1);

                      startDateParam = date.toDate();
                      endDatePram = tomorrow.toDate();
                  } else if (getDateRange() == 1) {//yesterday
                      DateTime date = new DateTime().toDateMidnight().toDateTime().minus(1);
                      DateTime yesterday = date.minusDays(1).plus(1);

                      startDateParam = yesterday.toDate();
                      endDatePram = date.toDate();
                  } else if (getDateRange() == 2) {//last 7 days
                      DateTime date = new DateTime();
                      DateTime yesterday = date.minusDays(7).toDateMidnight().toDateTime();

                      startDateParam = yesterday.toDate();
                      endDatePram = date.toDate();
                  } else if (getDateRange() == 3) {//this month
                      DateTime date = new DateTime();
                      int dayOfMonth = date.dayOfMonth().get();
                      DateTime yesterday = date.minusDays(dayOfMonth - 1).toDateMidnight().toDateTime();

                      startDateParam = yesterday.toDate();
                      endDatePram = date.toDate();
                  } else if (getDateRange() == 4) {//last month
                      DateTime date = new DateTime().toDateMidnight().toDateTime();
                      int dayOfMonth = date.dayOfMonth().get();
                      DateTime lastMonth = date.minusDays(dayOfMonth - 1).minus(1).toDateTime();
                      dayOfMonth = lastMonth.dayOfMonth().get();

                      date = lastMonth.minusDays(dayOfMonth).toDateTime();

                      startDateParam = date.plus(1).toDate();
                      endDatePram = lastMonth.toDate();
                  } else if (getDateRange() == 5) {//this year
                      DateTime enddate = new DateTime().toDateTime();
                      int dayOfYear = enddate.dayOfYear().get();
                      DateTime lastMonth = enddate.minusDays(dayOfYear - 1).toDateMidnight().toDateTime();

                      startDateParam = lastMonth.toDate();
                      endDatePram = enddate.toDate();
                  } else if (getDateRange() == 6) {//last year
                      DateTime endDate = new DateTime().toDateTime();

                      endDate = endDate.minusDays(endDate.getDayOfYear()).toDateMidnight().minus(1).toDateTime();
                      DateTime startDate = endDate.minusMonths(12).plus(1);

                      startDateParam = startDate.toDate();
                      endDatePram = endDate.toDate();
                  } else if (getDateRange() == 7) {//All
                      DateTime enddate = new DateTime().toDateTime();

                      startDateParam = enddate.toDate();
                      endDatePram = enddate.toDate();
                  }

              } else {
                  DateTimeFormatter fmt = DateTimeFormat.forPattern("MM/dd/yyyy");       //06/01/2012
                  startDateParam = DateTime.parse(getStartDate(), fmt).toDate();
                  endDatePram = DateTime.parse(getEndDate(), fmt).plusDays(1).minus(1).toDate(); //EOD


              }
              OrderFilter orderFilter = new OrderFilter(0, 10);
                orderFilter.setOrderType(OrderType.PURCHASE);

              try {
                  if (getCustomerId() > 0) {
                      CustomerEntity customerEntity = getUserManagement().getCustomer(getCustomerId());
                      orderFilter.setCustomer(customerEntity);

                  }


              } catch (EntityNotFoundException e) {
                  e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
              }

              orderFilter.setStartDate(startDateParam);
              orderFilter.setEndDate(endDatePram);
              if (getCity() != null && !getCity().trim().isEmpty())
                  orderFilter.setCity(getCity());

              loadOrders(orderFilter);


        return SUCCESS;
    }


    public String doAddItem() {


        this.orderEntity = (OrderEntity) getSession().get("purchaseEntity");

        try {
            ProductEntity product = getProductService().getProduct(getItemId());

            boolean found = false;

            for (OrderItemEntity itemEntity : orderEntity.getItemList()) {

                if (itemEntity.getProduct().getId() == product.getId()) {
                    itemEntity.setQuantity(itemEntity.getQuantity().add(new BigDecimal(1)));
                    found = true;
                    break;
                }

            }
            if (!found) {
                OrderItemEntity item = new OrderItemEntity();
                item.setQuantity(new BigDecimal(1));
                item.setSalePrice(product.getSalePrice());
                item.setProduct(product);
                item.setDiscount(new BigDecimal(0));


                orderEntity.getItemList().add(item);
            }


        } catch (EntityNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            addActionError("Unable to add item for sale!!");
        }


        //  gets


        return SUCCESS;
    }

    public String doEditItem() {
        ProductEntity product = null;
        try {
            product = getProductService().getProduct(getItemId());
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }

        this.orderEntity = (OrderEntity) getSession().get("purchaseEntity");

        for (OrderItemEntity itemEntity : orderEntity.getItemList()) {

            if (itemEntity.getProduct().getId() == product.getId()) {
                itemEntity.setQuantity(getQuantity());

                itemEntity.setSalePrice(getPrice());
                itemEntity.setDiscount(getDiscount());

                break;
            }
        }
        //product.setDescription(get);
        // product.setSalePrice(salePrice);
        // product.setLastPurchasePrice(price);
        // product.setStockQuantity(product.getStockQuantity().add(getQuantity()));
        //getProductService().updateProduct(product);


        return SUCCESS;
    }

    public String doDeleteItem() {
        this.orderEntity = (OrderEntity) getSession().get("purchaseEntity");

        ProductEntity product = null;
        try {
            product = getProductService().getProduct(getItemId());
            boolean found = false;

            for (OrderItemEntity itemEntity : orderEntity.getItemList()) {

                if (itemEntity.getProduct().getId() == product.getId()) {
                    orderEntity.getItemList().remove(itemEntity);

                    break;
                }

            }


        } catch (EntityNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


        return SUCCESS;
    }

    public String doAddShipping() {

        this.orderEntity = (OrderEntity) getSession().get("purchaseEntity");
        orderEntity.setShippingAmount(getShippingAmount());
        return SUCCESS;
    }

    public String doDeleteShipping() {

        this.orderEntity = (OrderEntity) getSession().get("purchaseEntity");
        orderEntity.setShippingAmount(null);
        return SUCCESS;
    }

    public String doDelete() {
        try {
            OrderEntity orderEntity = getOrderManagement().getOrder(getOrderId());
            getOrderManagement().deleteOrder(orderEntity);

        } catch (EntityNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return SUCCESS;
    }

    public String doDeleteDiscount() {

        this.orderEntity = (OrderEntity) getSession().get("purchaseEntity");
        orderEntity.setDiscount(null);
        return SUCCESS;
    }

    public String doAddPayment() {

        PaymentType paymentTypeEntity = PaymentType.CASH.getType(getPaymentType());


        this.orderEntity = (OrderEntity) getSession().get("purchaseEntity");

        boolean found = false;

        for (OrderPaymentEntity itemEntity : orderEntity.getPaymentList()) {

            if (itemEntity.getType().getId() == getPaymentType()) {

                itemEntity.setAmount(itemEntity.getAmount().add(getPaymentAmount()));
                found = true;
                break;
            }

        }
        if (!found) {
            OrderPaymentEntity payment = new OrderPaymentEntity();
            payment.setAmount(getPaymentAmount());
            payment.setType(paymentTypeEntity);

            orderEntity.getPaymentList().add(payment);
        }

        return SUCCESS;
    }

    public String doDeletePayment() {
        this.orderEntity = (OrderEntity) getSession().get("purchaseEntity");


        for (OrderPaymentEntity itemEntity : orderEntity.getPaymentList()) {

            if (itemEntity.getType().getId() == getPaymentType()) {

                orderEntity.getPaymentList().remove(itemEntity);

                break;
            }

        }

        return SUCCESS;
    }


    public String doAddCustomer() {
        CustomerEntity userEntity = null;
        try {
            userEntity = getUserManagement().getCustomer(getCustomerId());
        } catch (EntityNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        this.orderEntity = (OrderEntity) getSession().get("purchaseEntity");

        this.orderEntity.setCustomer(userEntity);


        return SUCCESS;
    }

    public String doAddComment() {
        this.orderEntity = (OrderEntity) getSession().get("purchaseEntity");

        orderEntity.setNote(getComment());

        return SUCCESS;
    }

    public String doAddDiscount() {
        this.orderEntity = (OrderEntity) getSession().get("purchaseEntity");

        orderEntity.setDiscount(getDiscount());

        return SUCCESS;
    }


    public String doDeleteCustomer() {

        this.orderEntity = (OrderEntity) getSession().get("purchaseEntity");

        orderEntity.setCustomer(null);

        return SUCCESS;
    }

    public String doListSuspended() {
        OrderFilter filter = new OrderFilter(0, 10);
        filter.setStatus(OrderStatus.SUSPENDED);


        loadOrders(filter);

        return SUCCESS;
    }


    public String doSuspend() {
        this.orderEntity = (OrderEntity) getSession().get("purchaseEntity");
        orderEntity.setOrderStatus(OrderStatus.SUSPENDED);
        getOrderManagement().createOrder(orderEntity);
        getSession().remove("orderEntity");
        return SUCCESS;
    }

    public String doCancel() {

        getSession().remove("orderEntity");
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(-1);
        getSession().put("purchaseEntity", orderEntity);
        return SUCCESS;
    }

    public String doComplete() {

        this.orderEntity = (OrderEntity) getSession().get("purchaseEntity");
        orderEntity.setNote(getComment());
        orderEntity.setOrderStatus(OrderStatus.COMPLETED);
        orderEntity.setOrderType(OrderType.PURCHASE);
        //  getSession().remove("orderEntity");


        if (orderEntity.getId() != -1)
            this.orderEntity = getOrderManagement().updateOrder(orderEntity);
        else

            this.orderEntity = getOrderManagement().createOrder(orderEntity);

        getSession().remove("purchaseEntity");
        return SUCCESS;
    }

    public String doLoad() {

        this.orderEntity = (OrderEntity) getSession().get("purchaseEntity");
        orderEntity.setNote(getComment());

        //  getSession().remove("orderEntity");
        return SUCCESS;
    }

    public String doReceipt() {
        return SUCCESS;
    }

    public String doUnSuspend() {


        this.orderEntity = (OrderEntity) getSession().get("purchaseEntity");


        try {
            this.orderEntity = getOrderManagement().getOrder(getOrderId());
            getSession().put("purchaseEntity", this.orderEntity);
        } catch (EntityNotFoundException e) {

            return ERROR;
        }


        return SUCCESS;
    }

    public String changeMode() {

        this.orderEntity = (OrderEntity) getSession().get("purchaseEntity");

        // orderEntity.setOrderType(new OrderType(mode));


        return SUCCESS;
    }


}
