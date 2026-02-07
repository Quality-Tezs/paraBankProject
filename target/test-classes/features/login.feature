Feature: Login

Scenario: Login to ParaBank
  Given user opens parabank site
  When user logs in
  Then login should be successful
