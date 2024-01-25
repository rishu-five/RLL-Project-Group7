package com.EPayRollManagementTest.MainTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AdminTestClass {
  @Test
  public void invalidLogin() throws InterruptedException {
	  WebDriver driver = new ChromeDriver();
	  driver.get("http://localhost:4200/");
	  driver.findElement(By.xpath("/html/body/app-root/home-image/div/div/div[1]/button")).click();
	  driver.findElement(By.linkText("Sign in")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.id("employeeId")).sendKeys("200");
	  driver.findElement(By.id("password")).sendKeys("123456");
	  driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[1]/form/div[3]/button")).click();
	  driver.close();
  }
  
  @Test
  public void validLogin() throws InterruptedException {
	  WebDriver driver = new ChromeDriver();
	  driver.get("http://localhost:4200/");
	  driver.findElement(By.xpath("/html/body/app-root/home-image/div/div/div[1]/button")).click();
	  driver.findElement(By.linkText("Sign in")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.id("employeeId")).sendKeys("12345");
	  driver.findElement(By.id("password")).sendKeys("Rishu@12345");
	  driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[1]/form/div[3]/button")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//html/body/app-root/app-admin-menu/html/body/nav/div/button/span")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id=\"employeeMenuNavbar\"]/div[2]/ul/li[2]/a")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id=\"employeeMenuNavbar\"]/div[1]/button")).click();
	  Thread.sleep(100);
	  //clicking the edit profile button
	  driver.findElement(By.xpath("/html/body/app-root/app-admin-menu/app-profile/section/div/div/div/div/div[1]/div[1]/button")).click();
//	  driver.findElement(By.xpath("/html/body/app-root/app-admin-menu/app-profile/section/div/div/div/div/div[1]/div[1]/button")).click();
	  Thread.sleep(2000);
////	  driver.findElement(By.name("edit")).click();
////	  Thread.sleep(1000);
	  driver.findElement(By.name("name")).clear();
	  driver.findElement(By.name("name")).sendKeys("Rishu");
//	  driver.findElement(By.name("editButton")).click();
	  //driver.findElement(By.name("gender")).clear();
	  driver.findElement(By.name("gender")).sendKeys("Male");
	  driver.findElement(By.name("mailId")).clear();
	  driver.findElement(By.name("mailId")).sendKeys("rishu@gmail.com");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("/html/body/app-root/app-admin-menu/app-profile/div/div/form/button")).submit();
	  Thread.sleep(1000);
  Alert alert =driver.switchTo().alert();
	  alert.accept();
	  driver.close();
  }
  
  @Test
  public void addEmployeeTest() throws InterruptedException
  {
	  WebDriver driver = new ChromeDriver();
	  driver.get("http://localhost:4200/");
	  driver.findElement(By.xpath("/html/body/app-root/home-image/div/div/div[1]/button")).click();
	  driver.findElement(By.linkText("Sign in")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.id("employeeId")).sendKeys("12345");
	  driver.findElement(By.id("password")).sendKeys("Rishu@12345");
	  driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[1]/form/div[3]/button")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("/html/body/app-root/app-admin-menu/nav/div/button/span")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id=\"employeeMenuNavbar\"]/div[2]/ul/li[3]/a")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id=\"employeeMenuNavbar\"]/div[2]/ul/li[3]/ul/li[1]/a")).click();
	  
	  //navbar close button xpath:-//*[@id="employeeMenuNavbar"]/div[1]/button
	  
	  driver.findElement(By.xpath("//*[@id=\"employeeMenuNavbar\"]/div[1]/button")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.name("Name")).sendKeys("Rishu");
	  driver.findElement(By.name("mailid")).sendKeys("rishu@gmail.com");
	  driver.findElement(By.name("role")).sendKeys("Employee");
	  driver.findElement(By.name("category")).sendKeys("HR");
	  driver.findElement(By.name("gender")).sendKeys("Male");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("/html/body/app-root/app-admin-menu/app-create-employee/div/form/button")).submit();
	  Thread.sleep(2000);
	  Alert alert = driver.switchTo().alert();
	  alert.accept();
	  driver.close();
	  
  }
  @Test
  public void viewAllEmployeesUpdateAndDelete() throws InterruptedException
  {
	  WebDriver driver = new ChromeDriver();
	  driver.get("http://localhost:4200/");
	  
	  driver.findElement(By.xpath("/html/body/app-root/home-image/div/div/div[1]/button")).click();
	  driver.findElement(By.linkText("Sign in")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.id("employeeId")).sendKeys("12345");
	  driver.findElement(By.id("password")).sendKeys("Rishu@12345");
	  driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[1]/form/div[3]/button")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("/html/body/app-root/app-admin-menu/nav/div/button/span")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id=\"employeeMenuNavbar\"]/div[2]/ul/li[3]/a")).click();
	  driver.findElement(By.xpath("//*[@id=\"employeeMenuNavbar\"]/div[2]/ul/li[3]/ul/li[2]/a")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id=\"employeeMenuNavbar\"]/div[1]/button")).click();
	  Thread.sleep(2000);
	  driver.close();
  }
  
  @Test
  public void adminSalarayTest() throws InterruptedException
  {
	  WebDriver driver = new ChromeDriver();
	  driver.get("http://localhost:4200/");
	  
	  driver.findElement(By.xpath("/html/body/app-root/home-image/div/div/div[1]/button")).click();
	  driver.findElement(By.linkText("Sign in")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.id("employeeId")).sendKeys("12345");
	  driver.findElement(By.id("password")).sendKeys("Rishu@12345");
	  driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[1]/form/div[3]/button")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("/html/body/app-root/app-admin-menu/nav/div/button/span")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id=\"employeeMenuNavbar\"]/div[2]/ul/li[5]/a")).click();
	  driver.findElement(By.xpath("//*[@id=\"employeeMenuNavbar\"]/div[1]/button")).click();
	  driver.findElement(By.xpath("/html/body/app-root/app-admin-menu/app-admin-salary/div[1]/button[1]")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.name("employeeId")).clear();
	  driver.findElement(By.name("employeeId")).sendKeys("12347");
	  driver.findElement(By.name("salary")).sendKeys("500000");
	  
	  driver.findElement(By.name("date")).sendKeys("05-01-2024",Keys.TAB);
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("/html/body/app-root/app-admin-menu/app-admin-salary/div[2]/form/button")).click();
	  Thread.sleep(2000);
	  Alert alert = driver.switchTo().alert();
	  alert.accept();
	  Thread.sleep(2000);
	  driver.close();
	  
  }
  
  @Test
  public void leaveTest() throws InterruptedException
  {
	  WebDriver driver = new ChromeDriver();
	  driver.get("http://localhost:4200/");
	  
	  driver.findElement(By.xpath("/html/body/app-root/home-image/div/div/div[1]/button")).click();
	  driver.findElement(By.linkText("Sign in")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.id("employeeId")).sendKeys("12345");
	  driver.findElement(By.id("password")).sendKeys("Rishu@12345");
	  driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[1]/form/div[3]/button")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("/html/body/app-root/app-admin-menu/nav/div/button/span")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id=\"employeeMenuNavbar\"]/div[2]/ul/li[6]/a")).click();
	  driver.findElement(By.xpath("//*[@id=\"employeeMenuNavbar\"]/div[1]/button")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.name("employeeId")).sendKeys("12347");
	  driver.findElement(By.name("leaveType")).sendKeys("Casual");
	  driver.findElement(By.name("startDate")).sendKeys("10-12-2023",Keys.TAB);
	  driver.findElement(By.name("endDate")).sendKeys("14-01-2024",Keys.TAB);
	  driver.findElement(By.name("reason")).sendKeys("Personal Issue");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("/html/body/app-root/app-admin-menu/app-leave/div[1]/form/button")).click();
	  Alert alert = driver.switchTo().alert();
	  alert.accept();
	  driver.close();
	  
	  
	  
	  
  }
  @Test
  private void scheduleWorkTest() throws InterruptedException
  {
	  WebDriver driver = new ChromeDriver();
	  driver.get("http://localhost:4200/");
	  driver.findElement(By.xpath("/html/body/app-root/home-image/div/div/div[1]/button")).click();
	  driver.findElement(By.linkText("Sign in")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.id("employeeId")).sendKeys("12345");
	  driver.findElement(By.id("password")).sendKeys("Rishu@12345");
	  driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[1]/form/div[3]/button")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("/html/body/app-root/app-admin-menu/nav/div/button/span")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id=\"employeeMenuNavbar\"]/div[2]/ul/li[7]/a")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id=\"employeeMenuNavbar\"]/div[2]/ul/li[7]/ul/li[1]/a")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id=\"employeeMenuNavbar\"]/div[1]/button")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.id("employeeId")).sendKeys("101");
	  driver.findElement(By.id("date_assigned")).sendKeys("14-01-2024",Keys.TAB);
	  driver.findElement(By.id("is_work_assigned")).sendKeys("Selenium");
	  driver.findElement(By.id("work_description")).sendKeys("Complete testing of login module");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("/html/body/app-root/app-admin-menu/app-schedule-work/div/div[1]/form/div[5]/button")).click();
	  Thread.sleep(2000);
	  Alert alert = driver.switchTo().alert();
	  alert.accept();
	  
	  driver.close();
	  
  }
  @Test
   public void attendance() throws InterruptedException
   {
	   WebDriver driver = new ChromeDriver();
		  driver.get("http://localhost:4200/");
		  driver.findElement(By.xpath("/html/body/app-root/home-image/div/div/div[1]/button")).click();
		  driver.findElement(By.linkText("Sign in")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.id("employeeId")).sendKeys("12345");
		  driver.findElement(By.id("password")).sendKeys("Rishu@12345");
		  driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[1]/form/div[3]/button")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/app-root/app-admin-menu/nav/div/button/span")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//*[@id=\"employeeMenuNavbar\"]/div[2]/ul/li[9]/a")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//*[@id=\"employeeMenuNavbar\"]/div[2]/ul/li[9]/ul/li[1]/a")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//*[@id=\"employeeMenuNavbar\"]/div[1]/button")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.id("employeeId")).sendKeys("12347");
		  driver.findElement(By.id("date")).sendKeys("14-01-2024",Keys.TAB);
		  driver.findElement(By.id("check_in")).sendKeys("8");
		  driver.findElement(By.id("check_out")).sendKeys("6");
		  driver.findElement(By.id("status")).sendKeys("Present");
		  driver.findElement(By.xpath("/html/body/app-root/app-admin-menu/app-attendance/div/div[1]/form/div[6]/button")).click();
		  Thread.sleep(1000);
		  Alert alert = driver.switchTo().alert();
		  alert.accept();
		  Thread.sleep(1000);
		  driver.close();
		  	  
   }
  @Test
  private void signout() throws InterruptedException
  {
	  WebDriver driver = new ChromeDriver();
	  driver.get("http://localhost:4200/");
	  driver.findElement(By.xpath("/html/body/app-root/home-image/div/div/div[1]/button")).click();
	  driver.findElement(By.linkText("Sign in")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.id("employeeId")).sendKeys("12345");
	  driver.findElement(By.id("password")).sendKeys("Rishu@12345");
	  driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[1]/form/div[3]/button")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("/html/body/app-root/app-admin-menu/nav/div/button/span")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id=\"employeeMenuNavbar\"]/div[2]/ul/button")).click();
	  Thread.sleep(1000);
	  driver.close();
  }
  
}
