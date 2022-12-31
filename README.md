# Bloodify
## Implemented:
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
