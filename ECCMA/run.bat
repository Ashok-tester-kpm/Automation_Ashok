set projectLocation= C:\Users\Jaya prakash\eclipse-workspace\ECCMA
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\testng.xml
pause