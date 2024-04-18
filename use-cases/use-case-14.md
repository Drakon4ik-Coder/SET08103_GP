# USE CASE: 14 city Report by region
## CHARACTERISTIC INFORMATION

### Goal in Context

As a *user*, I want *to generate a report on all cities in the region specified by me, organized by their population in descending order* so that *I can quickly view the regional population distribution.*

### Scope

System.

### Level

Primary task.

### Preconditions

Database contains city data.

### Success End Condition

A report is displayed to the user.

### Failed End Condition

No report is produced.

### Primary Actor

Application user.

### Trigger

User chooses city report by region option

## MAIN SUCCESS SCENARIO

1. User chooses city report for region option
2. The report is displayed to the user

## EXTENSIONS

1. **The database is not reachable**:
    1. The program informs the user a connection error has occurred.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 2.0