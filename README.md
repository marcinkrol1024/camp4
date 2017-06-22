TASK 1 - testing
-----

Shop(mapOfProductsToPrice, mapOfDayOfWeekToDiscount)
* getDiscountedProductPrice(product)

TASK 2 - testing
------

TimeDisplay
* getDayOfWeek - name of week
* getMonth - name of month

TASK 3 - serialization basics
------

Create list of users, save to users.bin, then read and write out to console
Create test to check if read users are equal to written users

User - class
* name: String
* age: int
* credentials: Credentials - class
  * username: String
  * password: String
  
TASK 4 - serialization with transient
------

Create building, serialize and deserialize<br>
All inhabitants count should be cached after first execution<br>
Cached values should be transient<br>
Create test for get all inhabitants count<br>
Create test to check if cache gets serialized<br>

Building - class
* apartmentInhabitantsCounts: List\<Integer>
* getAllInhabitantsCount: int