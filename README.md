# Spring Boot Microservice for Caliber Staging Module

## Revature Project #3

### Team Members:
- Andrew Curry - Testing & Assigning Associates to Managers
- Mareo Yapp - Viewing all associates assigned to a Manager, Testing and Documentation
- Saleel Bey - Documentation, Styling, Retrieving Managers and associates
- Suva Shahria - View recently graduated associates to staging assigned to a Manager, Testing, Modals
- Ben Johnston - Developed listening service in Java that periodically checks Caliber for new batches.
- Patrick Warring - Viewing, Creating, and Updating SWOT analysis for associates
- Connor Ryan - Testing, Devops, Project structuring / reformating and Working on SWOT Analysis 

### Executive Summary
- The Caliber API system will...
- A manager can login and view all associates automatically assigned to them by the system.
- A SWOT analysis can be created for an associate.

#### Manager User Stories
- A manager can view all associates assigned to him.
- A manager can view all associates that are new to staging.
- The system will automatically assign associates to a staging manager.

#### SWOT User Stories
- A manager can create a SWOT analysis for an associate in order to decide actions the associate should prioritize.
- A manager can view previous SWOT.
- A manager can add items to a SWOT.
 
![](./imgs/AD.png)

**Architecture Diagram**

![](./imgs/ERD.PNG)
**ERD Diagram**

Associate status' are enum staging and project. Analysis type are enum strengths, weaknesses, opportunities and threats.

### Technical Used
- Frontend:
  - Angular11
  - AngularFire/Firebase
  - Animate.css Library
  - Jasmine
  - Karma
  - Bootstrap
  - HTML5
  - CSS3
  - Caliber API
- Backend:
  - Spring Boot
  - Spring Data
  - Java8
  - Maven
  - JUnit
  - Mockito
  - PostgreSQL
  - Log4j
  - Lombok
- Devops:
  - Jenkins
  - AWS EC2
  - AWS RDS
  - Docker
- Other
  - Git
  - Agile methodologies
