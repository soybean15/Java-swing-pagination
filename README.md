# Java Swing Pagination

Simple pagination library you can use on your Java swing projects.

## Jar File
- Download the jar file [here](https://github.com/soybean15/Java-swing-pagination/releases).



## How to use
1. Create a **JPanel** container where you want to store your pagination buttons. JPanel container = new JPanel();
```
JPanel container = new JPanel();
```
2. Instantiate **PaginationHandler**.
```java

int set =10;
int totalItems = 102;
int numbersOfButton =5;
/**
@params 1 : numbers of item you want to display every page
@params 2 : total number of item you want to display
@params 3 : number of buttons on pagination (if less than 5, it will default to 5).
**/
PaginationHandler paginationHandler = new PaginationHandler(set, totalItems, numbersOfButton);
```
3. Add the pagination to the container you created on step 1.
```java
container.add(paginationHandler.getPagination());
```
4. Add mouse click listener.

```java
paginationHandler.addMouseListener(new PaginationMouseListener(){
            
            @Override
            public void onClick(PaginationEvent e) {  //on click event  
                
                populate( e.startIndex(),  e.endIndex());
                pages.setText("Page "+e.getCurrentPage()+" of "+e.getTotalPage());

            }
            @Override
            public void onSelected(PaginationEvent e){
              
                //change background color to red and foreground to yellow once selected
                e.getButton().setBackground(Color.red);
                e.getButton().setForeground(Color.yellow);
                
            }
            @Override
            public void onHover(PaginationEvent e){
              
                //mouse entered event
                e.getButton().setBackground(Color.green);               
                
            }

          
        });
```


## Other method
 - You can change the design of your buttons by using the **.modifyButton()** method.
 sample:
 ```java    
   //this methods used consumer function
   
   paginationHandler.modifyNextAndPreviousButton((previous, next)->{//for previous and next button
            previous.setBackground(Color.blue);
            previous.setForeground(Color.green);
            next.setBackground(Color.red);
            next.setForeground(Color.white);
            next.setText("Next");
            
    });
    
    paginationHandler.modifyButton(label -> { //modify page buttons
            label.setOpaque(true);
            label.setBackground(Color.ORANGE);   
            label.setForeground(Color.BLACK);
    });
        
        
 ```
 
 ## PaginationEvent 
 Contains basic data you need for your pagination. 
 
 - **getStartIndex()** returns starting index
 - **getStartIndex()** returns ending index
 - **getOffSet()** returns the offset (can be used on SQL pagination)
 - **getCurrentPage()** returns current page number
 

 ## Sample Usage
- See sample usage [here](https://github.com/soybean15/Java-swing-pagination/tree/master/src/sample).

