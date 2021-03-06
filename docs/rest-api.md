#Abq Parks controller documentation.


## HTTP://localhost:25052/rest/abq_park


Abq Parks controller documentation from Spring MVC annotations



**Version** v1

[**Terms of Service**]()












# APIs


## /amenities


### GET

<a id="getAmenities"></a>









#### Request



##### Parameters






#### Response

**Content-Type: ** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | <a href="#/definitions/IterableAmenity">IterableAmenity</a>|


















## /parks


### GET

<a id="allParks"></a>









#### Request



##### Parameters






#### Response

**Content-Type: ** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | <a href="#/definitions/IterablePark">IterablePark</a>|







### POST


<a id="post"></a>









#### Request


**Content-Type: ** application/json

##### Parameters

<table border="1">
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <th>body</th>
    <td>body</td>
    <td>no</td>
    <td></td>
    <td> - </td>

    <td>
    
    <a href="#/definitions/Park">Park</a> 
    </td>

</tr>


</table>



#### Response




| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | <a href="#/definitions/Park">Park</a>|















## /parks/{amenitiesId}


### GET

<a id="searchParks"></a>









#### Request



##### Parameters

<table border="1">
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <th>amenitiesId</th>
    <td>path</td>
    <td>yes</td>
    <td></td>
    <td> - </td>

    
            <td>Array[integer] (csv)</td>
    

</tr>


</table>



#### Response

**Content-Type: ** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | <a href="#/definitions/IterablePark">IterablePark</a>|


















## /reviews/{args}






### POST


<a id="post"></a>









#### Request


**Content-Type: ** application/json

##### Parameters

<table border="1">
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <th>args</th>
    <td>path</td>
    <td>yes</td>
    <td></td>
    <td> - </td>

    
            <td>Array[integer] (csv)</td>
    

</tr>

<tr>
    <th>body</th>
    <td>body</td>
    <td>no</td>
    <td></td>
    <td> - </td>

    <td>
    
    <a href="#/definitions/Review">Review</a> 
    </td>

</tr>


</table>



#### Response




| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | <a href="#/definitions/Review">Review</a>|















## /reviews/{parkId}


### GET

<a id="getReviews"></a>









#### Request



##### Parameters

<table border="1">
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <th>parkId</th>
    <td>path</td>
    <td>yes</td>
    <td></td>
    <td> - </td>

    
            <td>integer (int64)</td>
    

</tr>


</table>



#### Response

**Content-Type: ** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | <a href="#/definitions/IterableReview">IterableReview</a>|


















## /users






### POST


<a id="post"></a>









#### Request


**Content-Type: ** application/json

##### Parameters

<table border="1">
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <th>body</th>
    <td>body</td>
    <td>no</td>
    <td></td>
    <td> - </td>

    <td>
    
    <a href="#/definitions/User">User</a> 
    </td>

</tr>


</table>



#### Response




| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | <a href="#/definitions/User">User</a>|
















# Definitions

## <a name="/definitions/Amenity">Amenity</a>

<table border="1">
    <tr>
        <th>name</th>
        <th>type</th>
        <th>required</th>
        <th>description</th>
        <th>example</th>
    </tr>
    
        <tr>
            <td>id</td>
            <td>
                
                    
                    integer (int64)
                
            </td>
            <td>optional</td>
            <td>-</td>
            <td></td>
        </tr>
    
        <tr>
            <td>name</td>
            <td>
                
                    
                    string
                
            </td>
            <td>optional</td>
            <td>-</td>
            <td></td>
        </tr>
    
        <tr>
            <td>displayName</td>
            <td>
                
                    
                    string
                
            </td>
            <td>optional</td>
            <td>-</td>
            <td></td>
        </tr>
    
        <tr>
            <td>parks</td>
            <td>
                
                
                    array[<a href="#/definitions/Park">Park</a>]
                
                
                
            </td>
            <td>optional</td>
            <td>-</td>
            <td></td>
        </tr>
    
</table>

## <a name="/definitions/Park">Park</a>

<table border="1">
    <tr>
        <th>name</th>
        <th>type</th>
        <th>required</th>
        <th>description</th>
        <th>example</th>
    </tr>
    
        <tr>
            <td>id</td>
            <td>
                
                    
                    integer (int64)
                
            </td>
            <td>optional</td>
            <td>-</td>
            <td></td>
        </tr>
    
        <tr>
            <td>name</td>
            <td>
                
                    
                    string
                
            </td>
            <td>optional</td>
            <td>-</td>
            <td></td>
        </tr>
    
        <tr>
            <td>latitude</td>
            <td>
                
                    
                    number (double)
                
            </td>
            <td>optional</td>
            <td>-</td>
            <td></td>
        </tr>
    
        <tr>
            <td>longitude</td>
            <td>
                
                    
                    number (double)
                
            </td>
            <td>optional</td>
            <td>-</td>
            <td></td>
        </tr>
    
        <tr>
            <td>amenities</td>
            <td>
                
                
                    array[<a href="#/definitions/Amenity">Amenity</a>]
                
                
                
            </td>
            <td>optional</td>
            <td>-</td>
            <td></td>
        </tr>
    
        <tr>
            <td>reviews</td>
            <td>
                
                
                    array[<a href="#/definitions/Review">Review</a>]
                
                
                
            </td>
            <td>optional</td>
            <td>-</td>
            <td></td>
        </tr>
    
        <tr>
            <td>href</td>
            <td>
                
                    
                    string (uri)
                
            </td>
            <td>optional</td>
            <td>-</td>
            <td></td>
        </tr>
    
</table>

## <a name="/definitions/Review">Review</a>

<table border="1">
    <tr>
        <th>name</th>
        <th>type</th>
        <th>required</th>
        <th>description</th>
        <th>example</th>
    </tr>
    
        <tr>
            <td>id</td>
            <td>
                
                    
                    integer (int64)
                
            </td>
            <td>optional</td>
            <td>-</td>
            <td></td>
        </tr>
    
        <tr>
            <td>date</td>
            <td>
                
                    
                    string (date-time)
                
            </td>
            <td>optional</td>
            <td>-</td>
            <td></td>
        </tr>
    
        <tr>
            <td>review</td>
            <td>
                
                    
                    string
                
            </td>
            <td>optional</td>
            <td>-</td>
            <td></td>
        </tr>
    
        <tr>
            <td>park</td>
            <td>
                
                    <a href="#/definitions/Park">Park</a>
                    
                
            </td>
            <td>optional</td>
            <td>-</td>
            <td></td>
        </tr>
    
        <tr>
            <td>user</td>
            <td>
                
                    <a href="#/definitions/User">User</a>
                    
                
            </td>
            <td>optional</td>
            <td>-</td>
            <td></td>
        </tr>
    
        <tr>
            <td>href</td>
            <td>
                
                    
                    string (uri)
                
            </td>
            <td>optional</td>
            <td>-</td>
            <td></td>
        </tr>
    
</table>

## <a name="/definitions/User">User</a>

<table border="1">
    <tr>
        <th>name</th>
        <th>type</th>
        <th>required</th>
        <th>description</th>
        <th>example</th>
    </tr>
    
        <tr>
            <td>id</td>
            <td>
                
                    
                    integer (int64)
                
            </td>
            <td>optional</td>
            <td>-</td>
            <td></td>
        </tr>
    
        <tr>
            <td>googleID</td>
            <td>
                
                    
                    string
                
            </td>
            <td>optional</td>
            <td>-</td>
            <td></td>
        </tr>
    
        <tr>
            <td>firstName</td>
            <td>
                
                    
                    string
                
            </td>
            <td>optional</td>
            <td>-</td>
            <td></td>
        </tr>
    
        <tr>
            <td>lastName</td>
            <td>
                
                    
                    string
                
            </td>
            <td>optional</td>
            <td>-</td>
            <td></td>
        </tr>
    
        <tr>
            <td>userEmail</td>
            <td>
                
                    
                    string
                
            </td>
            <td>optional</td>
            <td>-</td>
            <td></td>
        </tr>
    
        <tr>
            <td>href</td>
            <td>
                
                    
                    string (uri)
                
            </td>
            <td>optional</td>
            <td>-</td>
            <td></td>
        </tr>
    
</table>


