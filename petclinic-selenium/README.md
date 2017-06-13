# Radu's Selenium Test cases for Spring PetClinic Sample Application

## Prerequisites before running the tests locally :

* The petclinic app is running at localhost:8080. More info on how to run the petclinic app <a href="https://github.com/radood/automation/tree/master/spring-petclinic">here</a>.

* Chromedriver is installed at the location: $HOME/automation and is added to your path.

* Chrome is installed on your machine.

## Running the test cases locally:

```
git clone https://github.com/radood/automation/tree/master/petclinic-selenium
cd petclinic-selenium
mvn clean test
```

## List of test cases:

### Happy/Critical path: 

On Homepage:

* The homepage displays without any errors and returns a 200 ok.

On Find Owners page:

* Clicking the find owner button without an input displays a list of all the owners and their details.
* Clicking the find owner button with one exsisting last name returns that owner's profile.
* Clicking the find owner button with multiple exsisting last names returns a list of all the owners and their details under that name.
* Clicking on one of the owners from the list expands to that owners profile with complete details.
* Clicking the add new owner button takes you to the add new owner page.

On the Owner Profile page:

* Clicking edit owner takes you to the owner editing page and any of the fields can be updated.
* Clicking add new pet takes you to the pet creation page.
* Clicking edit pet takes you to the pet editing page and any of the fields can be updated.
* Clicking add visit takes you to the visit creation page.

On the Add New Owner page:

* The First Name field can be successfully filled without any errors.
* The Last Name field can be successfully filled without any errors.
* The Address field can be successfully filled without any errors.
* The City field can be successfully filled without any errors.
* The Telephone field can be successfully filled with only numeric characters and without any errors.
* Clicking the add new owner button creates a new owner provided all the above fields are filled correctly.

On the Add New Pet page:

* Name field can be successfully filled without any errors.
* Birthday field can be successfully filled without any errors.
* Each of the 6 pet types from the dropdown are valid inputs.

On the Visit Creation page:

* The date field can be successfully filled without any errors.
* The description field can be successfully filled without any errors.
* Clicking add visit successfuly adds a visit for that specific pet.

On the Veterinarians page:

* A list of all the veterenarians and their specialties is displayed.
* The list can be viewed as JSON.
* The list can be viewed as XML.

On Errorpage:

* The errorpage displays and returns a 500 error response.

### Non Happy/Critical path: 
(Which will not be implemented as automation tests since it was not in requirements)

* Try all the imput fields with a multitude of inputs ranging from caps, numbers, symbols, malicious html etc.
* Stop the server midway through a request of creating an owner or a pet
* Try breaking the search field with options related on unrelated to the given data
* Input a large number of owners and pets to see if performance of page/database is affected
* Editing the same field for the same owner on different machines/browsers

## Small demo that shows the tests

The screen recorder couldn't handle the automation scripts and would make my screen load way longer but I assure you all the tests work as well as the first one.

![Test demo](/petclinic-selenium/out.gif?raw=true)


## Bugs found:

* Create new pet page button says "update pet" instead of "add new pet".
* Telephone field empty error is not caught/user friendly: "numeric value out of bounds (<10 digits>.<0 digits> expected)".
* The valid date format is unclear. It requires exactly the format "2010/09/07" but the user is not told this anywhere or in the error message.
* On the veterenarians page. "View as XMLView as JSON" are right next to each other without any spaces.
* There is an invisible tab to the left of the home tab.
