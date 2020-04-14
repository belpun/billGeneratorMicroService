# Micro Services example:

Threre are three micro-serivces and one eureka server:

 -Item web service (port 8081): this web service gives details about the item.
 
 -Customer web service (port 8082): give detail information about the customer.
 
 -Bill web service (port 8083): Given the day and customer id, it produces the bill for that day. This web service will connect to item web service and customer
 webservice to get the customer info and item info
 
 -Eureka discovery server: this will avoid hard coding the host name and port. This will also facilitate load balancing 


