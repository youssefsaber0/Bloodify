# Bloodify
## Implemented:
Implemented 2 Main Screens:
- Institution Home Screen:
A scrollable screen that can be updated by pulling down.
Contains all requests of the institution
Each request can be clicked on  to redirect to transaction screen

<p align="center">
<img src="https://user-images.githubusercontent.com/26904065/208301481-71fe407d-eed0-4bae-9b38-cda395922d5c.png" alt="drawing" height="600"/>
</p>

- Institution Event Screen
A scrollable screen that can be updated by pulling down.
Contains all events by the institution 
Each event can be clicked on to redirect to transaction screen
Have an add button that can be clicked to redirect to create event

<p align="center">
<img src="https://user-images.githubusercontent.com/26904065/208301894-77ec284a-f4b5-4c32-8c96-c4f920c9dc04.png" alt="drawing" height="600"/>
</p>

Also added the new Navbar for institution

<p align="center">
<img src="https://user-images.githubusercontent.com/26904065/208301556-1d035723-1963-4330-a93f-c44ccb8da395.png" alt="drawing" width="600"/>
</p>

Added the following models (will be merged later with Saber and Karim models):
- Event
- Transaction

Added some fonts, colors, styles in shared directory to be used across the application.


# create  UI for a transaction from and to the institute and through a post
## 1.  user can donate to another user through the post and the institute confirms it 
![image](https://user-images.githubusercontent.com/77590247/208730779-995f4682-0b47-4012-acda-c54ca07e1ae2.png)
### API 
![image](https://user-images.githubusercontent.com/77590247/208730956-135a21c8-2e26-453b-9674-a490b223699d.png)

## 2.  user can donate to  an institute through
![image](https://user-images.githubusercontent.com/77590247/208731299-749c4a1b-f35a-4e51-bf3d-64941893e0db.png)
### API 
![image](https://user-images.githubusercontent.com/77590247/208731924-14721b37-68a4-4276-af8d-b4481b126486.png)

## 3. institute can give blood bags to user 
![image](https://user-images.githubusercontent.com/77590247/208731703-8012b575-3dc6-435b-85fb-39820c916130.png)
## API

![image](https://user-images.githubusercontent.com/77590247/208731533-08860f47-6a2f-42ca-8049-2ac90548d6eb.png)

### **Implemented the 3 different transaction types:**

- User to User donation
- Institution to User donation
- User to Institution donation

**Details:**
- 3 different reposotries are created (one for each transaction type) and instead of relying on the repostory interface (the one that implements the jpa repo) a new layer is added ( data access object aka dao) that helps in **filtering** as well as ""catching exception thrown by the repo**
-  A single service is created (that uses the 3 mentioned daos)
- A single controller is created (that uses the menetioned service)
- In order to combine the request object and the data needed from the JSON web token (aka jwt) a dto is created containing the institution email as well as the request fields
- Mapping the request object to dto is done by a dedicated dto mapper
- In order to transfer the dto to the model entities, model mappers are used (annotated with service)
- Different exception are thrown (found in exceptions/transactionexceptions directory) to reflect potential problems that might in the different layers
- A single reponse is created (TransactionResponse) that has a boolean (state) -> true in case of accepted transaction and false o.w. and a message (String) -> contains (Successful Transaction!) in case of accepted transaction or different set of message that reflect the problem happened during applying the transaction


**Note: User to User is not tested using postman since it depends on the existence of post entity as well as its service.
Therefore its testing is delayed until merging**


# Implemented
* Saving user requests for blood (posts) in the DB
* The user is able to update, and delete a post
* Deleting posts after as soon as its expiry date has come using a scheduled operation
* Deleting posts after as soon as required number of bags is collected
* Searching for compatible blood types to a certain blood type in institutions
# Changes in the design
![image](https://user-images.githubusercontent.com/95547833/208795057-b8bcf5a2-6cb7-419c-a266-ea4278c3ba8b.png)

* Changing the hierarchy of decorator pattern so that RHD class wraps Blood Group class as it is easier in implementation
* Using Blood Group as Singleton
# Testing

* Junit and Mockito for unit and component testing
* Postman testing for API testing

## Blood Finding UI

- Institution search ui was added: A user can search for blood bags in institutions before creating a donation request, the institution name and location and distance and available blood bags are displayed.
- Blood donation form was added: The user selects the reciepient blood type, the number of blood bags needed (max 4 per post), the expiration date (max 30 days) of the request, the institution in which the donation will take place.

- api needs to be implemented.
- Better naming might be done.

![image](https://user-images.githubusercontent.com/89037036/208801150-97e96393-8993-4173-afdb-63be0b64b367.png)

![image](https://user-images.githubusercontent.com/89037036/208801117-395e7b9c-a396-4580-a697-bab4d5bb86f2.png)

![image](https://user-images.githubusercontent.com/89037036/208801241-1a84d4bf-2e7f-45fa-bd7b-a0d4d94238cb.png)

### Implemented the event part of instituion:
- Allow the creation of  events
- Allow the deletion of events (every 2 minutes deleteion is done to expired events)
- Allow to get all the active events of an instituion 

**Note: some postman tests will fail due to the fact that this branch doesn't contain the transaction part**

#  event creation in front
![image](https://user-images.githubusercontent.com/77590247/208864991-26b64e79-20f6-4b86-a2a4-4912ca39a2c8.png)
## location pick
![image](https://user-images.githubusercontent.com/77590247/208865124-d1dbe93d-0e9d-4acb-b4eb-1c3ca7a66936.png)
## start date 
![image](https://user-images.githubusercontent.com/77590247/208865241-690aa1cc-59d6-4c06-9ec3-9a458367b37a.png)
## working hours
![image](https://user-images.githubusercontent.com/77590247/208865326-881fd2f8-51a4-4c7e-bb7e-ec8705eb82f5.png)

## transaction done
### use case 
![image](https://user-images.githubusercontent.com/77590247/208926848-6dd4b056-0ba1-43ab-a376-4b4f2f0c07b2.png)

### Chat Functionality:
- Chat model: messages are presisted in the database.
![chatClassDiagram drawio (2)](https://user-images.githubusercontent.com/89037036/209894223-d0f39553-a11e-46b7-9237-da0ea488d996.svg)
---
### Notification System:
- create notification history for each user 
- Send notification to user device if user login

![Capture](https://user-images.githubusercontent.com/77590247/210057708-9973ca22-3a8a-4555-8527-e27a8198fa8b.PNG)
---
### Forget Password:
- Email Service
- PasswordResetRepo
User can request to change his password, a 4-digit code is sent to him through email, then the user is asked to enter the 4 digits code and new password in order to change his password.

(New classes and method are in yellow)

![AccountManager](https://user-images.githubusercontent.com/26904065/209904798-0c7e38bb-9479-4a8b-bd08-29331575e6ed.svg)
---
### Institution Statistics:
It contains 5 packages:  3 services, a common package for wrapping and an interfaces package
the 3 services we collect statistics about are:
- Institutions available blood bags counts for each blood type
- Required blood bags in Posts with their numbers concerning a specific institution.
- Transactions on blood bags types with their numbers, for: user to institution transaction (the only source for blood bags that enters institutions), and all 3 types of transactions (user -> user, user -> institution, institution ->user)
-----------
User Interface:
### Chat:
<p align="center">
<img src="https://user-images.githubusercontent.com/89037036/209997896-7420381e-5eb6-4547-9e53-7457decfbc9a.png" alt="drawing" height="400"/>
</p>

### Account Settings and Forget Password:

<p align="center">
<img src="https://user-images.githubusercontent.com/95588088/210016784-2e823a7b-bbe4-4606-ae4a-bf1ac536c883.jpg" alt="drawing" height="400"/>
<img src="https://user-images.githubusercontent.com/95588088/210016869-22d8c365-6f10-4b78-8b1a-55195f45ac98.jpg" alt="drawing" height="400"/>
<img src="https://user-images.githubusercontent.com/95588088/210017129-793d9e2f-e3e0-4d1f-b05f-48f4d4e94962.jpg" alt="drawing" height="400"/>
</p>

### Posts and Events for User:
<p align="center">
<img src="https://user-images.githubusercontent.com/26904065/209758177-a9c38b18-622a-40ae-9e69-6b4c8929a5c1.png" alt="drawing" height="400"/>
<img src="https://user-images.githubusercontent.com/26904065/209758431-c93cc23a-dabe-4aac-b9c5-01f059d6eb9c.png" alt="drawing" height="400"/>
<img src="https://user-images.githubusercontent.com/26904065/209759058-e769588f-40a1-49d7-a49f-41afd1bd1168.png" alt="drawing" height="400"/>
</p>

### Notification System:
<p align="center">
<img src="https://user-images.githubusercontent.com/77590247/210057875-57eaa3f9-5c95-488f-b14c-e6d38dbea465.PNG" alt="drawing" height="400"/>
<img src="https://user-images.githubusercontent.com/77590247/210057948-c6cc2a86-34af-4db9-b463-cd5816145dd4.PNG" alt="drawing" width="200"/>
<img src="https://user-images.githubusercontent.com/77590247/210057996-f0443610-56ba-48d4-9ab9-7cedb59c04c9.PNG" alt="drawing" width="200"/>
</p>
