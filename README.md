This backend was made to provide the data needed on the Mobi7 Code Task.
It exposes some REST services:

/pois - returns all POI objects

/pois/{poi_name} - return a specific POI

/posicao/placas - returns all the car plates in a list of strings

/posicao - takes 2 optional arguments: placa and date and returns the position objects.
Example of REST call: http://localhost:8080/posicao?placa=TESTE001&data=12%2F16%2F2018
If no arguments are provided, all positions are returned.
