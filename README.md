## Discription:

This project can be used to transform an odata v2 EDMX file to a open API 3.0 swagger file.

## Usage:

You can run the class TestImplementation directly.
The program need you to input the full path of the input EDMX file with below prompt:

**Input the full path of the file you want to transform:**

And you can directly use the file in example folder, such as:
**C:\[your project path]\\SwaggerTransformer\examples\com.sap.gtt.app.tfo.TFOService_metadata.xml**

Then the result file will be generated under your project path.
In this case, **com.sap.gtt.app.tfo.TFOService_metadata_V4_edmx.*xml*** and **com.sap.gtt.app.tfo.TFOService_metadata.*json*** will be generated, and the JSON file can be used as the input of the swagger editor.
