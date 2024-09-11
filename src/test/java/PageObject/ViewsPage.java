package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ViewsPage {
	
	private WebDriver driver;
	
	public int pop_upcount=0;
	
	//public static int pop_upcount1=0;
	
	public ViewsPage(WebDriver driver)
	{
		this.driver=driver;	}
	
	By progressbar=By.xpath("//div[@id='UH_ProgressBarDiv' and contains(@style,'block')]");
	
	By ajaxloader=By.xpath("//div[@id='CV1_Ajax_LoaderGrayLayer' and contains(@style,'block')]");
	
	By tagall_button=By.xpath("//span[@id='CV4_tagAll']");
	
	By untagall_button=By.xpath("//span[@id='CV4_unTagAll']");
	
	By dialogconfirm_popup=By.xpath("(//div[@id='dialog-confirm'])");
	
	By ok_button=By.xpath("//button[@type='button']//span[text()='OK']");
	
	By chart_progressbar=By.xpath("//div[@id='CV4_progressbar' and contains(@style,'block')]");
	
	By view_mastercheckbox=By.xpath("//div[@class='CV5_gen-input-ckhbx-wrapper masterCkbox ']");
	
	By note_icon=By.xpath("//img[@class='CV4_note_icon']");
	
	By note_popup=By.xpath("//div[@id='CV12_NotesPopUP']");
	
	By note_textarea=By.xpath("//textarea[@id='CV12_TxtNotes']");
	
	By note_addbutton=By.xpath("//span[text()='Add']");
	
	By note_popup_okbutton=By.xpath("(//span[text()='Ok'])");
	
	By note_alertmessage=By.xpath("//div[@id='CV32_AlertMessageForMultiCheck']");
	
	By click_focusview=By.xpath("//span[@id='cv4_load_Visualization']");
	
	By focus_dialogpopup=By.xpath("//div[@id='I8_DesignateFocus_Popup']");
	
	By focus_dialogpopup_confirmbutton=By.xpath("//span[@id='DesignatedFocusconformBtn']");
	
	By focus_svg=By.xpath("//*[name()='svg' and @class='bubble']");
	
	By button_quicksave=By.xpath("//span[@id='CV4_SubHeader-Save']");
	
	By chart_save=By.xpath("//span[@id='UH_gen_header_SaveURL_Quick']");
	
	By block_save=By.xpath("//div[@id=\"UH_ProecessingDialog\" and contains(@style,'display: block')]");
	
	String dialogconfirm="(//div[@id='dialog-confirm'])[%value%]";
	
	String dialog_ok_button="(//button[@type='button']//span[text()='OK'])[%value%]";
	
	String tagColor="//span[@class='gen-cursor-hand CV4_full-view-tags-%value%']";
	
	String popup_note_okbutton="(//span[text()='Ok'])[%value%]";
	
	
	
	 public void loadView()
	 {
		CommonFunction.isElementDisplayed(ajaxloader, 120);
		 
		 CommonFunction.ajaxLoader(ajaxloader);
	 }
	 
	 
	 public void accessFocusView()
	 {
		 driver.findElement(click_focusview).click();
		 
		 CommonFunction.explicitWait(focus_dialogpopup, 60);
		 
		 driver.findElement(focus_dialogpopup_confirmbutton).click();
		 
		 CommonFunction.explicitWait(focus_svg, 60);
	 }
	 
	 
	 
	 public void navigateViews() throws InterruptedException
	 {
		 List<WebElement> tabs=driver.findElements(By.xpath("//div[@id='CV4_Subheader_Views']//span[contains(@id,'cv4_load')]"));
		 
		 System.out.println(tabs.size());
		 
		 while(tabs.size()==0)
		 {
			 tabs=driver.findElements(By.xpath("//div[@id='CV4_Subheader_Views']//span[contains(@id,'cv4_load')]"));
		 }
		 
		 System.out.println(tabs.size());
		 
		 for(int i=1;i<tabs.size();i++)
		 {
			 tabs=driver.findElements(By.xpath("//div[@id='CV4_Subheader_Views']//span[contains(@id,'cv4_load')]"));
			 
			 String tabName=tabs.get(i).getAttribute("data-id");
			 
			 System.out.println(tabName);
			 
			 try
			 {
			 tabs.get(i).click();
			 
			 CommonFunction.ajaxLoader(ajaxloader);
			 
			 Thread.sleep(5000);
			 }
			 catch(Exception e)
			 {
				 System.out.println("Exception Occured");			
			 }
			 
			 
		 }
	 }
	 
	 
	 public void selectView(String viewName)
	 {
      
		 List<WebElement> tabs=driver.findElements(By.xpath("//div[@id='CV4_Subheader_Views']//span[contains(@id,'cv4_load')]"));
		 
		 System.out.println(tabs.size());
		 
		 while(tabs.size()==0)
		 {
			 tabs=driver.findElements(By.xpath("//div[@id='CV4_Subheader_Views']//span[contains(@id,'cv4_load')]"));
		 }
		 
		 System.out.println(tabs.size());
		 
		 for(int i=1;i<tabs.size();i++)
		 {
			 tabs=driver.findElements(By.xpath("//div[@id='CV4_Subheader_Views']//span[contains(@id,'cv4_load')]"));
			 
			 String tabName=tabs.get(i).getAttribute("data-id");
			 
			 System.out.println(tabName);
			 
			 if(tabName.contains(viewName))
			 {
			 tabs.get(i).click();
			 
			 CommonFunction.ajaxLoader(ajaxloader);
			 
			 break;
			 
			 }
		 }
	 }
	 
	 
	 
	 public void tagAll_untagAll(String option) throws InterruptedException
	 {
		 switch(option)
		 {
		 
		 case "tagAll":
			 
			// driver.findElement(tagall_button).click();
			 
			 CommonFunction.clickElement(tagall_button, 60);
			 
			 break;
			 
		 case "UntagAll":
			 
			 // driver.findElement(untagall_button).click();
			 
			 CommonFunction.clickElement(untagall_button, 60);
			 
			 break;
		 }
		 
		 Thread.sleep(5000);
		 
		 System.out.println("Pop-Up Count" +  pop_upcount);
		 
		// System.out.println("Pop-Up Count1" +  pop_upcount1);
		 
         List<WebElement> dialog=driver.findElements(dialogconfirm_popup);
		 
		 System.out.println("Pop-Up" + dialog.size());
		 
		 System.out.println("Pop-Up Count" +  ++pop_upcount);
		 
		// System.out.println("Pop-Up Count1" +  ++pop_upcount1);
		 
		//boolean status= CommonFunction.explicitWait(dialogconfirm_popup, 5);
		
		boolean status= CommonFunction.explicitWait(CommonFunction.getXPath(dialogconfirm, dialog.size()), 15);
		
		if(status==true)
		{
			String text=driver.findElement(CommonFunction.getXPath(dialogconfirm, dialog.size())).getText();
			
			System.out.println(text);
			
			driver.findElement(CommonFunction.getXPath(dialog_ok_button, dialog.size())).click();
			
			status= CommonFunction.explicitWait(CommonFunction.getXPath(dialogconfirm, dialog.size()), 15);
			
			if(status==false)
			{
				System.out.println("Dialog Confirm Pop-Up is closed successfully");
			}
			else
			{
				System.out.println("Dialog Confirm Pop-Up is not closed");
			}
		}
		
		else
		{
			System.out.println("Dialog Confirm Pop-Up is not displays");
		}
	 }
	 
	 
	 public void verifyTagAddedToAllRecords()
	 {
		
		 List<WebElement> records=driver.findElements(By.xpath("//li[@data-wncheaderid='0']"));
		 
		 System.out.println(records.size());
		 
		 for(int i=1;i<=records.size();i++)
		 {
			 String referenceCode=driver.findElement(By.xpath("(//li[@data-wncheaderid='0'])["+i+"]")).getAttribute("data-cv5_li_referencecode");
			 
			 System.out.println(referenceCode);
			 
			 if(referenceCode.contains("No  References Found.")||referenceCode.isEmpty())
			 {
				 
			 }
			 else
			 {
				 String tag=driver.findElement(By.xpath("//span[@data-id='isTagged' and @data-cv5_span_referencecode='"+referenceCode+"']")).getText();
				 
				 System.out.println("TAG =>> " + tag);
				 
				 if(tag.length()>0)
				 {
					 System.out.println("Tag Added Succsessfully"); 
				 }
				 else
				 {
					 System.out.println("Tag Removed Succsessfully"); 
				 }
			 }
		 }
		 
	 }
	 
	 
	 public void accessChart() throws InterruptedException
	 {
		 driver.findElement(By.xpath("//span[@id='s2_scr_chart']")).click();
		 
		 CommonFunction.explicitWait(chart_progressbar,60);
		 
		 List<WebElement> progressbar=driver.findElements(chart_progressbar);
		 
		 System.out.println(progressbar.size());
		 
		 while(progressbar.size()>0)
		 {
			 progressbar=driver.findElements(chart_progressbar);
		 }
		 
		 System.out.println("Chart loaded successfully");
		 
		 Thread.sleep(5000);
	 }
	 
	 
	 public void clickExitChart()
	 {
		 driver.findElement(By.xpath("//span[@id='CV2_Exit_Chart']")).click();
	 }
	 
	 
	 public void ajaxLoader() throws InterruptedException
	 {
         
		 CommonFunction.explicitWait(ajaxloader,10);
		 
		 List<WebElement> progressbar=driver.findElements(ajaxloader);
		 
		 System.out.println(progressbar.size());
		 
		 while(progressbar.size()>0)
		 {
			 progressbar=driver.findElements(ajaxloader);
		 }
		 
		 System.out.println("Ajax_LoaderGrayLayer ");
		 
		 Thread.sleep(2000);
	 }
	 
	 public void navigateToAllRecords()
	 {
       
		 List<WebElement> records=driver.findElements(By.xpath("//li[@data-wncheaderid='0']"));
		 
		 System.out.println(records.size());
		 
		 for(int i=1;i<=records.size();i++)
		 {
			 String referenceCode=driver.findElement(By.xpath("(//li[@data-wncheaderid='0'])["+i+"]")).getAttribute("data-cv5_li_referencecode");
			 
			 System.out.println(referenceCode);
			 
			 if(referenceCode.contains("No  References Found."))
			 {
				 
			 }
			 else
			 {
				 String tag=driver.findElement(By.xpath("//span[@data-id='isTagged' and @data-cv5_span_referencecode='"+referenceCode+"']")).getText();
				 
				 System.out.println(tag);
			 }
		 }
	 }
	 
	 
	 public void selectMasterCheckbox() throws InterruptedException
	 {
		CommonFunction.selectCheckBox(view_mastercheckbox);
		 
		//CommonFunction.getClickText(tagColor, "Orange");
	 }
	 
	 
	 public void applyTag()
	 {
		 CommonFunction.getClickText(tagColor, "Orange");
	 }
	 
	 
	 public void addNoteToMultipleRecords()
	 {
		 driver.findElement(note_icon).click();
		 
		 CommonFunction.explicitWait(note_popup,60);
		 
		 driver.findElement(note_textarea).sendKeys("Note Added");
		 
		 driver.findElement(note_addbutton).click();
		 
		 CommonFunction.explicitWait(note_alertmessage,60);
		 
		 int count=CommonFunction.waitWhileLoop(note_popup_okbutton);
		 
		 System.out.println("count " + count);
		 
		 driver.findElement(CommonFunction.getXPath(popup_note_okbutton, 3)).click();
		 	 
	 }
	 
	 
	 public void verifyNoteAddedToAllRecords()
	 {
		
		 List<WebElement> records=driver.findElements(By.xpath("//li[@data-wncheaderid='0']"));
		 
		 System.out.println(records.size());
		 
		 for(int i=1;i<=records.size();i++)
		 {
			 String referenceCode=driver.findElement(By.xpath("(//li[@data-wncheaderid='0'])["+i+"]")).getAttribute("data-cv5_li_referencecode");
			 
			 System.out.println(referenceCode);
			 
			 if(referenceCode.contains("No  References Found.")||referenceCode.isEmpty())
			 {
				 
			 }
			 else
			 {
				 String note=driver.findElement(By.xpath("//span[@id='CV5_NoteIcon' and @data-cv5_span_referencecode='"+referenceCode+"']")).getAttribute("data-cv5_hasnotes");
				 
				 System.out.println(note);
				 
				 if(note.equalsIgnoreCase("True"))
				 {
					 System.out.println("Note Added Succsessfully"); 
				 }
				 else
				 {
					 System.out.println("Note Removed Succsessfully"); 
				 }
			 }
		 }
		 
	 }
	 
	 
	 public void showOnlyFilter() throws InterruptedException
	 {
		 driver.findElement(By.xpath("//span[@id='ShowonlyClick']")).click();
		 
		 Thread.sleep(5000);
		 
		 List<WebElement> showFilter=driver.findElements(By.xpath("//div[@id='Common_DropDown_Partial']/div"));
		 
		 System.out.println( "ShowFilter Size " + showFilter.size());
		 
		 for(int i=0;i<showFilter.size();i++)
		 {
			 System.out.println(showFilter.get(i).getText());
			 
			 if(showFilter.get(i).getText().equalsIgnoreCase("Untagged Records"))
			 {
				 showFilter.get(i).click();
				 
				 break;
			 }
		 }
	 }
	 
	 
	 public void clickQuickSave()
	 {
		 driver.findElement(button_quicksave).click();
	 }
	 
	 
	 public void clickChartSave()
	 {
		 driver.findElement(chart_save).click();
	 }
	 
	 
	 public void verifySaveDocument() throws InterruptedException
	 {
		 CommonFunction.explicitWait(block_save,60);
		 
		 List<WebElement> block=driver.findElements(block_save);
		 
		 System.out.println(block.size());
		 
		 while(block.size()>0)
		 {
			 block=driver.findElements(block_save);
		 }
		 
		 System.out.println(block.size());
		 
         Thread.sleep(5000);
		 
		// System.out.println("Pop-Up Count" +  pop_upcount);
		 
		// System.out.println("Pop-Up Count1" +  pop_upcount1);
		 
         List<WebElement> dialog=driver.findElements(dialogconfirm_popup);
		 
		 System.out.println("Pop-Up" + dialog.size());
		 
		 System.out.println("Pop-Up Count" +  ++pop_upcount);
		 
		// System.out.println("Pop-Up Count1" +  ++pop_upcount1);
		 
		 if(dialog.size()==pop_upcount)
		 {
			 System.out.println("########### Save Document is not generated Successfully ##########"); 
		 }
		 else
		 {
			 System.out.println("Save Document is generated Successfully"); 
		 }
	 }
	
	 
	 
	 

}
