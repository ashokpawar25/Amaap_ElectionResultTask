# Amaap_ElectionResultTask

## Problem Statement

-It's election night! Exciting! We have a feed of election results from a data supplier. 
They will supply us a file which will be updated throughout the night as results come in.

A result will consist of:
 - A constituency
 - A repeating set of pairs with the party code and the votes cast

So for example:

Banglore, 11014, BJP, 17803, INC, 4923, CPI, 2069, NCP
Pune, INC, 9389, CPI, 4829, BJP, 3375, NCP, 3371, BSP, 309, IND

Party Codes -

BJP - Bhartiya Janta Party
INC - Indian National Congress
BSP - Bahujan Samaj Party
CPI - Communist Party of India
NCP - Nationalist Congress Party
IND - Independant

We want to transform this into a standard result that shows:

- the constituency name
- translates the party code into a full name
- shows the winner of the constituency


## Classes and Variables


### ConstituencyHead

- **States**:
  - `partCodeMapper`: class to map party code.
  - `dataSupplier`: class to supply the data of election result.

- **Constructors**:
  - `ConstituencyHead(PartCodeMapper partCodeMapper, DataSupplier dataSupplier)`: Initializes the local variables.

- **Behaviour**:
  - `analyzeResult()`: Analyze result and return winner for constituency.


### DataSupplier Class

- **States**:
  - `Map<String, Map<String, Integer>> result`: store the data of election.

- **Constructors**:
  - `DataSupplier(Map<String, Map<String, Integer>> result)`: Initializes local varibles.

- **Behaviour**:
  - `Map<String, Map<String, Integer>> getResult()`: Return the data of election.
  
 ### PartCodeMapper Class
- **States**:
  - `Map<String, String> mappings`: Store the party code and full name of party.

- **Constructors**:
  - `DataSupplier(Map<String, Map<String, Integer>> result)`: Initializes local varibles.

- **Behaviour**:
  - `Map<String, String> getMappings()`: returns the mapping of party with actual name.
  - `translatePartyCodeInFullName(String partyCode)`: Take party code as input and returns party full name.
