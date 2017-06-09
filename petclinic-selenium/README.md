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

On the Owner Profile page:


* Clicking edit owner takes you to the owner editing page and any of the fields can be updated.
* Clicking add new pet takes you to the pet creation page
* Clicking edit pet takes you to the pet editing page
* Clicking add visit takes you to the visit creation page


## Bugs found:

* Create new pet page button says update pet instead of add new pet.
* Telephone field empty error is not caught/user friendly: "numeric value out of bounds (<10 digits>.<0 digits> expected)" 