# Visitation

## Visitation
  - VisitationType
  - Vitals
    - bloodType - Enum
    - BloodPressure
    - Body Temperature
    - Pulse Rate
    - Weight
    - Height
    - Respiration rate
  - Nurse
  - Primary Care Provider - Doctor
  - Diagnosis

## VisitationType 
  - Name

## Appointment extends VisitationType
  - DateTime
  - Staff to see - Doctor
  - Staff who made appointment - Nurse

## Walk-in extend VisitationType

## Emergency extends VisitationType
  - Complaint
  - DateTime
  - EmergencyCode

## EmergencyCode
  - code
  - Info
