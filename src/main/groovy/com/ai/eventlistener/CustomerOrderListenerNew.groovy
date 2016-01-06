import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
class CustomerOrderListenerNew(){
    public CustomerOrderListenerNew(){}
    @Autowired
    com.ai.crm.customerorder.domain.service.interfaces.ICheckCustomerOrder icheckcustomerorderCheckCustomerOrder;
    @EventListener
    public void onCreateOrderRequested(com.ai.crm.customerorder.domain.event.createorder.CreateOrderRequested event)){
        icheckcustomerorderCheckCustomerOrder.checkCreateOrderRequest( event);
    }


}

