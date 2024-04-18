## USE CASE: World Capital City Report

### Goal in Context

As a user, I want to generate a report listing capital cities of the world in descending order of population, so that I can understand the distribution of populous capital cities globally.

### Scope

System.

### Level

Primary task.

### Preconditions

Database contains data about capital cities and their populations.

### Success End Condition

A report listing capital cities of the world in descending order of population is generated and displayed to the user.

### Failed End Condition

No report is produced.

### Primary Actor

Application user.

### Trigger

User requests the world capital city report.

#### MAIN SUCCESS SCENARIO

1. User requests the world capital city report.
2. The report is generated, listing capital cities in descending order of population.
3. The report is displayed to the user.

#### EXTENSIONS

- **The database is not reachable**:
  1. The program informs the user that a connection error has occurred.

#### SUB-VARIATIONS

None.

#### SCHEDULE

**DUE DATE**: Release 2.0

---

## USE CASE: Continent Capital City Report

### Goal in Context

As a user, I want to generate a report listing capital cities of a specific continent in descending order of population, so that I can analyze the populous capital cities within a continent.

### Scope

System.

### Level

Primary task.

### Preconditions

Database contains data about capital cities and their populations.

### Success End Condition

A report listing capital cities of the continent in descending order of population is generated and displayed to the user.

### Failed End Condition

No report is produced.

### Primary Actor

Application user.

### Trigger

User selects a continent and requests the continent capital city report.

#### MAIN SUCCESS SCENARIO

1. User selects a continent for the capital city report.
2. User specifies any additional parameters.
3. The report is generated, listing capital cities in descending order of population within the selected continent.
4. The report is displayed to the user.

#### EXTENSIONS

- **The database is not reachable**:
  1. The program informs the user that a connection error has occurred.

#### SUB-VARIATIONS

None.

#### SCHEDULE

**DUE DATE**: Release 2.0

---

## USE CASE: Region Capital City Report

### Goal in Context

As a user, I want to generate a report listing capital cities of a specific region in descending order of population, so that I can analyze the populous capital cities within a region.

### Scope

System.

### Level

Primary task.

### Preconditions

Database contains data about capital cities and their populations.

### Success End Condition

A report listing capital cities of the region in descending order of population is generated and displayed to the user.

### Failed End Condition

No report is produced.

### Primary Actor

Application user.

### Trigger

User selects a region and requests the region capital city report.

#### MAIN SUCCESS SCENARIO

1. User selects a region for the capital city report.
2. User specifies any additional parameters.
3. The report is generated, listing capital cities in descending order of population within the selected region.
4. The report is displayed to the user.

#### EXTENSIONS

- **The database is not reachable**:
  1. The program informs the user that a connection error has occurred.

#### SUB-VARIATIONS

None.

#### SCHEDULE

**DUE DATE**: Release 2.0
