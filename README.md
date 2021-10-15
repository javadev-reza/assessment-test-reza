# Assessment Test Telkom

## Preparation

* clone source code
* execute : mvn clean install
* go to the folder 'assessment-test-reza/target'
  
## Command Options
* originalFilePath : Source file path (after "assessment-test-reza-0.1.jar")
* -t, --target=<target>    Extension file: {json, txt}
* -o, --output=<output>    Destination file path: {*.json, *.txt}
* -h, --help               Show this help message and exit.

## How to run

* Run CLI : transform to Json
  - java -jar assessment-test-reza-0.1.jar /var/log/nginx/error.log -t json -o /User/johnmayer/Desktop/nginxlog.json

* Run CLI : transform to txt default
  - java -jar assessment-test-reza-0.1.jar /var/log/nginx/error.log -o /User/johnmayer/Desktop/nginxlog.txt
  
* Run CLI : transform to txt using '-t' option
  - java -jar assessment-test-reza-0.1.jar /var/log/nginx/error.log -t txt -o /User/johnmayer/Desktop/nginxlog.txt

##  
  
  ##### javadevreza@gmail.com