package com.EPayRollManagementTest.MainTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class EmployeeTestClass {
  @Test
  public void invalidLoginCheck() throws InterruptedException {
	  
	  WebDriver driver = new ChromeDriver();
	  driver.get("http://localhost:4200/");
	  driver.findElement(By.xpath("/html/body/app-root/home-image/div/div/div[1]/button")).click();
	  driver.findElement(By.xpath("/html/body/app-root/app-register/div/div[1]/form/div[5]/a")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.id("employeeId")).sendKeys("12347");
	  driver.findElement(By.id("password")).sendKeys("rr12345");
	  driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[1]/form/div[3]/button")).click();
	  driver.close();
	  
  }
  @Test
  public void validLoginCheck() throws InterruptedException
  {
	  
	  WebDriver driver = new ChromeDriver();
	  driver.get("http://localhost:4200/");
	  driver.findElement(By.xpath("/html/body/app-root/home-image/div/div/div[1]/button")).click();
	  driver.findElement(By.linkText("Sign in")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.id("employeeId")).sendKeys("12347");
	  driver.findElement(By.id("password")).sendKeys("rr12345");
	  driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[1]/form/div[3]/button")).click();
	  System.out.println("Valid Login");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("/html/body/app-root/app-employee-menu/nav/div/b/button")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id=\"employeeMenuNavbar\"]/div[2]/ul/li[2]/a")).click();
	  driver.findElement(By.xpath("//*[@id=\"employeeMenuNavbar\"]/div[1]/button")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("/html/body/app-root/app-employee-menu/app-profile/section/div/div/div/div/div[1]/div[1]/button")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.name("name")).clear();
	  driver.findElement(By.name("name")).sendKeys("Rishu");
	  driver.findElement(By.name("gender")).sendKeys("Male");
	  driver.findElement(By.name("mailId")).sendKeys("rishu@gmail.com");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("/html/body/app-root/app-employee-menu/app-profile/div/div/form/button")).submit();
	  Thread.sleep(1000);
	  Alert alert =driver.switchTo().alert();
	  Thread.sleep(1000);
	  alert.accept();
	  //Editing Details
	  driver.close();
	  
  }
  
  @Test
  public void myLeavesTest() throws InterruptedException
  {
	  WebDriver driver = new ChromeDriver();
	  driver.get("http://localhost:4200/");
	  driver.findElement(By.xpath("/html/body/app-root/home-image/div/div/div[1]/button")).click();
	  driver.findElement(By.linkText("Sign in")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.id("employeeId")).sendKeys("12347");
	  driver.findElement(By.id("password")).sendKeys("rr12345");
	  driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[1]/form/div[3]/button")).click();
	  System.out.println("Valid Login");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("/html/body/app-root/app-employee-menu/nav/div/b/button/span")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id=\"employeeMenuNavbar\"]/div[2]/ul/li[3]/a")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id=\"employeeMenuNavbar\"]/div[1]/button")).click();
	  Thread.sleep(2000);
	  driver.close();
  }
  
  @Test
 public void myAttendanceTest() throws InterruptedException
 {
	  WebDriver driver = new ChromeDriver();
	  driver.get("http://localhost:4200/");
	  driver.findElement(By.xpath("/html/body/app-root/home-image/div/div/div[1]/button")).click();
	  driver.findElement(By.linkText("Sign in")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.id("employeeId")).sendKeys("12347");
	  driver.findElement(By.id("password")).sendKeys("rr12345");
	  driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[1]/form/div[3]/button")).click();
	  System.out.println("Valid Login");
	  Thread.sleep(2000);
	  //Attendence Test
	  driver.findElement(By.xpath("/html/body/app-root/app-employee-menu/nav/div/b/button/span")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id=\"employeeMenuNavbar\"]/div[2]/ul/li[4]/a")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id=\"employeeMenuNavbar\"]/div[1]/button")).click();
	  Thread.sleep(2000);
	  driver.close();
 }
  @Test
 public void mySalaryTest() throws InterruptedException
 {
	  WebDriver driver = new ChromeDriver();
	  driver.get("http://localhost:4200/");
	  driver.findElement(By.xpath("/html/body/app-root/home-image/div/div/div[1]/button")).click();
	  driver.findElement(By.linkText("Sign in")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.id("employeeId")).sendKeys("12347");
	  driver.findElement(By.id("password")).sendKeys("rr12345");
	  driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[1]/form/div[3]/button")).click();
	  System.out.println("Valid Login");
	  Thread.sleep(2000);
	  //View Salaray
	  driver.findElement(By.xpath("/html/body/app-root/app-employee-menu/nav/div/b/button/span")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id=\"employeeMenuNavbar\"]/div[2]/ul/li[5]/a")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id=\"employeeMenuNavbar\"]/div[1]/button")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("/html/body/app-root/app-employee-menu/app-employee-salary-view/div/div/table/tbody/tr/td[5]/button")).click();
	  Thread.sleep(2000);
	  JavascriptExecutor topToBottom = (JavascriptExecutor) driver;
	  topToBottom.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	  
	  Thread.sleep(2000); 
	  
	  JavascriptExecutor bottomToTop = (JavascriptExecutor)driver;
	  bottomToTop.executeScript("window.scrollTo(document.body.scrollHeight,0);");
	  Thread.sleep(2000);
	  
	  driver.findElement(By.xpath("/html/body/app-root/app-employee-menu/app-employee-salary-view/div/div/div[1]/button[1]")).click();
	  Thread.sleep(1000);
	  Alert alert = driver.switchTo().alert();
	  alert.accept();
	  driver.close();
 }
  @Test
  public void myTaskTest() throws InterruptedException
  {
	  WebDriver driver = new ChromeDriver();
	  driver.get("http://localhost:4200/");
	  driver.findElement(By.xpath("/html/body/app-root/home-image/div/div/div[1]/button")).click();
	  driver.findElement(By.linkText("Sign in")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.id("employeeId")).sendKeys("12347");
	  driver.findElement(By.id("password")).sendKeys("rr12345");
	  driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[1]/form/div[3]/button")).click();
	  System.out.println("Valid Login");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("/html/body/app-root/app-employee-menu/nav/div/b/button/span")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id=\"employeeMenuNavbar\"]/div[2]/ul/li[6]/a")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id=\"employeeMenuNavbar\"]/div[1]/button")).click();
	  driver.close();
  }
  
//  @Test
//  public void ChangePassword() throws InterruptedException
//  {
//	  WebDriver driver = new ChromeDriver();
//	  driver.get("http://localhost:4200/");
//	  driver.findElement(By.xpath("/html/body/app-root/home-image/div/div/div[1]/button")).click();
//	  driver.findElement(By.linkText("Sign in")).click();
//	  Thread.sleep(2000);
//	  driver.findElement(By.id("employeeId")).sendKeys("12347");
//	  driver.findElement(By.id("password")).sendKeys("rr12345");
//	  driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[1]/form/div[3]/button")).click();
//	  System.out.println("Valid Login");
//	  Thread.sleep(2000);
//	  driver.findElement(By.xpath("/html/body/app-root/app-employee-menu/nav/div/b/button/span")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//*[@id=\"employeeMenuNavbar\"]/div[2]/ul/li[7]/a")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//*[@id=\"employeeMenuNavbar\"]/div[1]/button")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.id("employeeId")).sendKeys("12347");
//	  driver.findElement(By.id("newPassword")).sendKeys("rr12345456");
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("/html/body/app-root/app-employee-menu/app-change-password/div/div/div[2]/div/div[2]/div/form/button")).click();
//	  Alert alert = driver.switchTo().alert();
//	  alert.accept();
//	  Thread.sleep(1000);
//	  driver.close();
//	  
//	  
//  }
  @Test
  public void signOutTest() throws InterruptedException
  {
	  WebDriver driver = new ChromeDriver();
	  driver.get("http://localhost:4200/");
	  driver.findElement(By.xpath("/html/body/app-root/home-image/div/div/div[1]/button")).click();
	  driver.findElement(By.linkText("Sign in")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.id("employeeId")).sendKeys("12347");
	  driver.findElement(By.id("password")).sendKeys("rr12345");
	  driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[1]/form/div[3]/button")).click();
	  System.out.println("Valid Login");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("/html/body/app-root/app-employee-menu/nav/div/b/button/span")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id=\"employeeMenuNavbar\"]/div[2]/ul/button")).click();
	  Thread.sleep(2000);
	  driver.close();
  }
}
