# Object-Oriented-Design
Code containing most projects from Northeastern University Class


This README is for an image processing program created by Tehani Cabour and updated by Henry deGrasse and Wanru Shao for Northeastern University’s Object Oriented Design class. The image processing program works by loading in any image and altering the image and saving it as a new altered image.

Image manipulations Questions:

Mosaic an image implementation: Y
Script command to mosaic an image: Y
Mosaic an image from GUI: Y

Design:
In this assignment, the main goal we need to achieve is to add a mosaic function to the image processor to give the image a "stained glass window" effect. According to the requirements of Assignment 7, we need to add three new features to the code we received:
-Implement and test the mosaic function of the image in the provided code only 

-Add support for specifying image mosaics via script in the provided code: mosaic num-seeds source-image-name dest-image-name.

-Add support for image stitching via GUI to the provided code.
So we needed to make changes in the model, controller, and view parts of the code. Among them, the model part needed the most changes due to the addition of the most important new feature:mosaic.

Throughout the design process, in order to implement image mosaicking to be in harmony with the design given to us, we chose to strictly abide by the important OOD principle of open to extension but close to modification.

1.  In general, we use the"macro" concept to put all the basic image process into the function objects in the manipulation package. These operations can be considered as simple and direct operations to the images. Then we design methods in a model interface, the methods in the model interface would call these function objects to edit image accordingly.
2. Because of the open-closed principle, we didn't change our original design to include new image processing operations. We designed a new interface called Mosaic to hand the mosaic operation. We then developed a mosaickImpl class to implement the method in the Mosaic interface.
3. In the model interface, we added one method called mosaic and sharpen so that this method could call mosaicImpl function object when needed.
4. We also added one command class in the controller package because we needed this new command to call this mosaic method in the model(command pattern design). Since the original design adopts the command pattern design, our new design keeps the consistency with it.
5. Finally, we added the new script command "script "in the GUI and Script-based controller so that it could call the mosaic commands in step 4. We also added a new JMenuItem in the GUI for mosaic and add its action listener so that users could play with the new 
feature there.

Other Notes:
Based on our code provider, the intensity function of the histogram seems to work it's just really slow. They have a pretty old computer. An easy way I used to test if the image file is too big for it was by going into the ImageImpl class in the model and putting System.out.print in the getHistogram method intensity switch case, and if doesn't print that means intensity hasn't finished running. But all the functions work, just a quick note here.

Citation for Images
‘quincy’ - Wanru Shao
(and all of the rest of the quincy variations are also from Wanru Shao)
