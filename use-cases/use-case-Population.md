## USE CASE: World Population Report

### Goal in Context

As a user, I want to generate a report on the total population of the world, including the population in cities and outside of cities, so that I can understand the distribution of population globally.

### Scope

System.

### Level

Primary task.

### Preconditions

Database contains country and city population data.

### Success End Condition

A report displaying the total population of the world, population in cities, and population outside of cities is generated and displayed to the user.

### Failed End Condition

No report is produced.

### Primary Actor

Application user.

### Trigger

User requests the world population report.

#### MAIN SUCCESS SCENARIO

1. User requests the world population report.
2. The report is generated.
3. The report is displayed to the user.

#### EXTENSIONS

- **The database is not reachable**:
   1. The program informs the user that a connection error has occurred.

#### SUB-VARIATIONS

None.

#### SCHEDULE

**DUE DATE**: Release 2.0

---

## USE CASE: Continent Population Report

### Goal in Context

As a user, I want to generate a report on the total population of a specific continent, including the population in cities and outside of cities, so that I can analyze the population distribution within a continent.

### Scope

System.

### Level

Primary task.

### Preconditions

Database contains country and city population data.

### Success End Condition

A report displaying the total population of the continent, population in cities, and population outside of cities is generated and displayed to the user.

### Failed End Condition

No report is produced.

### Primary Actor

Application user.

### Trigger

User selects a continent and requests the continent population report.


#### MAIN SUCCESS SCENARIO

1. User selects a continent for the population report.
2. User specifies any additional parameters.
3. User specifies a result count limit.
4. The report is generated.
5. The report is displayed to the user.

#### EXTENSIONS

- **The database is not reachable**:
   1. The program informs the user that a connection error has occurred.

#### SUB-VARIATIONS

None.

#### SCHEDULE

**DUE DATE**: Release 2.0
---

## USE CASE: Country Population Report

### Goal in Context

As a user, I want to generate a report on the total population of a specific country, including the population in cities and outside of cities, so that I can understand the population distribution within a country.

### Scope

System.

### Level

Primary task.

### Preconditions

Database contains country and city population data.

### Success End Condition

A report displaying the total population of the country, population in cities, and population outside of cities is generated and displayed to the user.

### Failed End Condition

No report is produced.

### Primary Actor

Application user.

### Trigger

User selects a country and requests the country population report.


#### MAIN SUCCESS SCENARIO

1. User selects a country for the population report.
2. User specifies any additional parameters.
3. User specifies a result count limit.
4. The report is generated.
5. The report is displayed to the user.

#### EXTENSIONS

- **The database is not reachable**:
   1. The program informs the user that a connection error has occurred.

#### SUB-VARIATIONS

None.

#### SCHEDULE

**DUE DATE**: Release 2.0
---

## USE CASE: Region Population Report

### Goal in Context

As a user, I want to generate a report on the total population of a specific region, including the population in cities and outside of cities, so that I can analyze the population distribution within a region.

### Scope

System.

### Level

Primary task.

### Preconditions

Database contains country and city population data.

### Success End Condition

A report displaying the total population of the region, population in cities, and population outside of cities is generated and displayed to the user.

### Failed End Condition

No report is produced.

### Primary Actor

Application user.

### Trigger

User selects a region and requests the region population report.


#### MAIN SUCCESS SCENARIO

1. User selects a region for the population report.
2. User specifies any additional parameters.
3. User specifies a result count limit.
4. The report is generated.
5. The report is displayed to the user.

#### EXTENSIONS

- **The database is not reachable**:
   1. The program informs the user that a connection error has occurred.

#### SUB-VARIATIONS

None.

#### SCHEDULE

**DUE DATE**: Release 2.0
---

## USE CASE: District Population Report

### Goal in Context

As a user, I want to generate a report on the total population of a specific district, including the population in cities, so that I can understand the population distribution within a district.

### Scope

System.

### Level

Primary task.

### Preconditions

Database contains city population data.

### Success End Condition

A report displaying the total population of the district and population in cities is generated and displayed to the user.

### Failed End Condition

No report is produced.

### Primary Actor

Application user.

### Trigger

User selects a district and requests the district population report.


#### MAIN SUCCESS SCENARIO

1. User selects a district for the population report.
2. User specifies a result count limit.
3. The report is generated.
4. The report is displayed to the user.

#### EXTENSIONS

- **The database is not reachable**:
   1. The program informs the user that a connection error has occurred.

#### SUB-VARIATIONS

None.

#### SCHEDULE

**DUE DATE**: Release 2.0
---

## USE CASE: City Population Report

### Goal in Context

As a user, I want to generate a report on the total population of a specific city, so that I can understand the population of the city.

### Scope

System.

### Level

Primary task.

### Preconditions

Database contains city population data.

### Success End Condition

A report displaying the total population of the city is generated and displayed to the user.

### Failed End Condition

No report is produced.

### Primary Actor

Application user.

### Trigger

User selects a city and requests the city population report.


#### MAIN SUCCESS SCENARIO

1. User selects a city for the population report.
2. The report is generated.
3. The report is displayed to the user.

#### EXTENSIONS

- **The database is not reachable**:
   1. The program informs the user that a connection error has occurred.

#### SUB-VARIATIONS

None.

#### SCHEDULE

**DUE DATE**: Release 2.0