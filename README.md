# play-framework-blob

I recently had the problem to upload and store images with java play framework 
(version 2.3.x) as BLOB. Uploading and shoveling the data in an byte-array was 
a piece of cake, but getting the data back into an <img>-tag was not that 
straight forward at first sight.

Internet research showed me, that I am not the first person who had to deal with 
this problem. So here is a small code snippet with the solution, is essentially 
a simple one-liner.
