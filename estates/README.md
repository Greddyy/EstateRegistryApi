# EstateRegistry
Running instructions.
Application runs on http://localhost:8800 port, used with PostMan.
* To retrieve all the buildings by the all owners, enter http://localhost:8800/building and choose GET method.
* To retrieve buildings by the particular owner, enter id after the building/. For example, to retrieve all buildings by the owner of id 2, enter http://localhost:8800/building/2 and choose GET method.
* To add/save a new building to the application, go to the http://localhost:8800/saveBuilding, enter the required info for the new building and choose POST method.
* In order to update an existing building, choose an existing building by the id or get all buildings, then go to the http://localhost:8800/updateBuilding, change particular details and then choose PUT method.
* To delete an existing building, enter an id after the http://localhost:8800/deleteBuilding/. For example, to delete the buildings by the owner of id 2, enter http://localhost:8800/building/2 and choose DELETE method.
* To get the total estate tax sum of the particular ownerId, enter the ownerId after http://localhost:8800/owner/tax. For example, to retrieve estate tax sum by the owner of id 6, enter http://localhost:8800/owner/tax/6 and choose GET method. 
