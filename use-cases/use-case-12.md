# USE CASE: 12 City Report by country
## CHARACTERISTIC INFORMATION

### Goal in Context

As a *user*, I want *to view a report on all cities on the country specified by me, organized by their population, from the largest to smallest*, so that *I can quickly view the population distribution by country.*

### Scope

System.

### Level

Primary task.

### Preconditions

Database contains City data.

### Success End Condition

A report is displayed to the user.

### Failed End Condition

No report is produced.

### Primary Actor

Application user.

### Trigger

User chooses City report for country option

## MAIN SUCCESS SCENARIO

1. User chooses City report for country option
2. The report is displayed to the user

## EXTENSIONS

1. **The database is not reachable**:
    1. The program informs the user a connection error has occurred.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 2.0