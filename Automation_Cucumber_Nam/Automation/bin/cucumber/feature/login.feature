Feature: Login
In order to post a thread or comment
I have to login

Background:
Given I am an user
And I go to Login screen

	Scenario: Check the title of Login screen
	Then I see the "LOGIN_TITLE" is "Đăng nhập"
	
	Scenario: Check the placeholder of Username field
	Then I see the placeholder of "USERNAME" field is "Tên đăng nhập…"
	
	Scenario: Check the value of Login button
	Then I see the value of "LOGIN_BUTTON" is "Đăng nhập"
	
	Scenario: Check the text between Login and Register buttons
	Then I see the "TEXT" between Login and Register buttons is "Hoặc"
	
	Scenario: Check the value of Register button
	Then I see the value of "REGISTER_BUTTON" is "Tạo tài khoản"
	
	Scenario: Check successful login
	When I input "Namtest" into "USERNAME" field
	And I input "123456" into "PASSWORD" field
	And I click on "LOGIN_BUTTON"
	Then I login successfully
	
	Scenario: Check navigation when tapping on Register button
	When I click on "REGISTER_BUTTON"
	Then I am redirected to Register screen