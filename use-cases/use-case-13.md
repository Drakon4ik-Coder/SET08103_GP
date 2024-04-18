# USE CASE: 13 city Report for country(limit N)

## CHARACTERISTIC INFORMATION

### Goal in Context

As a *user*, I want *to generate a report on the top N populated cities on the country specified by me, where N is a value provided by me* so that *I can quickly find information on the most populated cities on the country.*

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

User chooses city report for country option

## MAIN SUCCESS SCENARIO

1. User chooses city report for country option
2. User specifies a result count limit.
3. The report is displayed to the user

## EXTENSIONS

1. **The database is not reachable**:
    1. The program informs the user a connection error has occurred.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 2.0