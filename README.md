**SHARE MEAL APP**

**Problem Statement:** Food shared, is food produced.

**Description:** A drastic increase can be seen in food waste. As per data given by Food and Agriculture Organization (http://www.fao.org/food-loss-and-food-waste/flw-data), 1/3rd of food produced for human consumption is wasted globally, which accounts for almost 1.3 billion tons per year. On the other hand, also as per WHO 20% of the population faces extreme food shortages. Hence there is a need to come up with a solution that can avoid food waste & can help feed the needy.

**Solution:** This android-based Food Waste Management system can assist in collecting the leftover food from hotels & restaurants to distribute among those in need. NGOs that are helping poor communities battle starvation & malnutrition can raise a request for food supply from restaurants through this application. Once the request is accepted, the NGOs can collect the food from the restaurants for its distribution. In this way this android-based food waste management system will help restaurants to reduce food waste and will help in feeding the poor and needy people.

In this system, we have tried to reduce restaurant food wastage by giving waste food to NGOs. Donors will raise a request, in case of any leftover food restaurants/hostels have. This request is sent to all NGO managers who are registered in the app. The NGO Manager then approves the request and assigns it to one of the NGO employees for takeaway and forwards the request to the restaurant. The leftover food at the restaurant/hostels can be given to NGOs at the end of the day.

**Advantages**

- Benefits will be both the restaurant (reducing food wastage), and the needy
- Keep track of waste food for the restaurant
- Users can play role in saving food wastage and helping the needy

**Limitations**

- Wrong inputs will affect the project outputs.
- Internet Connection is mandatory
- The android mobile user will not be able to insert or view details if the server goes down. Thus, there is a disadvantage to single-point failure.

**Functionality:** This application is divided into mainly 2 components- The donor interface and the NGO interface.

![Screenshot_1665500240](https://user-images.githubusercontent.com/100941430/195267923-43f8fc95-4f69-45eb-9cb4-1ffb5e1c36bd.png)


Donors and NGOs have separate registration and login interface:

![Screenshot_1665500246](https://user-images.githubusercontent.com/100941430/195268157-d188a541-cb95-4f3d-85ff-a0d1366e884d.png)
![Screenshot_1665500254](https://user-images.githubusercontent.com/100941430/195268249-b9a4376b-2a63-4728-9bed-63d0bc2408ef.png)


Similarly, we have different menu pages for donors and NGOs:

![Screenshot_1665500277](https://user-images.githubusercontent.com/100941430/195268610-c605a1c4-b38b-4eab-a83d-8ba87ef21b79.png)
![Screenshot_1665500368](https://user-images.githubusercontent.com/100941430/195268681-e24d25ae-6577-4d31-bbcb-9d884f2ad1b9.png)



Now donors like hostels,hotels etc can use donate, status and history options. In donate button they can mention food weight, suggest vehicle type, and also mention their mobile number and address. This data will then send to NGOs so that they can approve and accept their donation.

Donors can also check their donation status by clicking on the status button if it is pending, approved or received status. This way we can connect reduce food wastage.

![Screenshot_1665500292](https://user-images.githubusercontent.com/100941430/195268776-1a10c46c-573c-497f-b133-432c62d0497c.png)
![Screenshot_1665500302](https://user-images.githubusercontent.com/100941430/195268817-0e6b433b-892a-4c0b-94f6-8c98e1e9b136.png)
![Screenshot_1665500313](https://user-images.githubusercontent.com/100941430/195268852-ccfc7a4e-8308-490d-b6e7-1bb5a4e220de.png)
![Screenshot_1665500378](https://user-images.githubusercontent.com/100941430/195268891-53ab6231-7b9d-4ab6-9720-3c8482b82240.png)


**Concepts Used:**

**Frontend:**

- Jetpack Compose (UI)
- Compose Destinations (Navigations)
- Material Design
- Interact with UI and State, and Delegate properties

**Backend:**

- Firestore

**Future Scope:**

- Add chat functionality so that donors and NGOs can interact in a better way
- Add google map services for an accurate location-sharing feature
- Improve UI by adding images and other details of both types of users

**Github Link to the project:** [**Share Meal**](https://github.com/Photon3009/ShareMealApp)

**For testing:**

**Use this login credential for donor:**

**Id: user1@gmail.com**

**Password: useruser1 (alteast 6 digits)**

**Use this login credential for NGO:**

**Id: ngo@gmail.com**

**Password: ngongo1**

# Thanks for reading!
