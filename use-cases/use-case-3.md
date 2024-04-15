# USE CASE: 3 Country Report by continent
## CHARACTERISTIC INFORMATION

### Goal in Context

As a *user*, I want *to view a report on all countries on the continent specified by me, organized by their population, from the largest to smallest*, so that *I can quickly view the population distribution by continent.*

### Scope

System.

### Level

Primary task.

### Preconditions

Database contains country data.

### Success End Condition

A report is displayed to the user.

### Failed End Condition

No report is produced.

### Primary Actor

Application user.

### Trigger

User chooses country report for continent option

## MAIN SUCCESS SCENARIO

1. User chooses country report for continent option
2. The report is displayed to the user

## EXTENSIONS

1. **The database is not reachable**:
    1. The program informs the user a connection error has occurred.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 2.0