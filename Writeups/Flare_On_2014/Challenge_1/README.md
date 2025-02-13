- Use `die` tool, This is an PE32 file on windows code by C#
![image](images/die.png)

- Run the test and the screen will display
![image](images/screen1.png)

- After press **DECODE**, the screen will display
![image](images/screen2.png)

- Use `dnSpy` to analysis file, go to entrypoint. In the code, run `Form1` function which seems to display the form on the screen 
![image](images/entrypoint.png)

- Following `Form1` function, I get to the function to initialize the form. When click button **DECODE**, It call `btnDecode_Click()`
![image](images/init.png)

- Following `btnDecode_Click`. It seems to be doing some decoding 
![image](images/decode.png)

- Set breakpoint and I get the value of `dat_secret`, `text`, `text2`, `text3`
![image](images/breakpoint.png)
![image](images/flags.png)

- Finally I got the flag saved in `text` variable