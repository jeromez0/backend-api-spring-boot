# backend-api-spring-boot

### Use case: 
Our customers purchase items on myshop.com (similar to amazon.com) and they need to track the status of the orders  they placed. We need to build APIs to support web components to provide the status.

### Solution Architecture

![architecture](https://github.com/jeromez0/backend-api-spring-boot/blob/main/public/backend_api_diagram.png)

APP is the application that supports the UI (the screenshots shared above). You need to build the APP mS to  expose APIs to support the UI.  
We have two backend services where we need to get data from. 
Order – Holds the order information. Exposes API (documented in API definition below) to retrieve order  based on orderId. The order has customerId field which holds the identifier of the customer to whom the  order belongs to. 
Catalog – Holds the sku information. Exposes API (documented in API definition below) to retrieve the sku  information for a given plan or sku. 



### API Calls

![api_calls](https://github.com/jeromez0/backend-api-spring-boot/blob/main/public/swagger_apis.png)

Here is the summary of the APIs 
GET /order/{orderId} – This API give the order details for an order 
GET /catalog/sku/{skuId} – This API give the sku details for a given sku 
POST /orderactions/acceptShipDate – This API is to accept the user consent on the new ship date POST /orderactions/cancelItem – This API is to cancel the item on the order 
POST /orderactions/cancelOrder – This API is to cancel all the items on the order 
Here is the screen shot of the swagger, you should see. Please go through the examples (by expanding the API – blue  shade), model and descriptions of the fields by expanding each object in Schemas section
