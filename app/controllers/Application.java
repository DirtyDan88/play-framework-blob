package controllers;

import play.mvc.*;
import play.mvc.Http.*;
import play.mvc.Http.MultipartFormData.FilePart;

import play.data.Form;
import static play.data.Form.form;

import models.Image;
import views.html.*;

public class Application extends Controller {
    
    public static Result index() {
        return ok(index.render(
                form(UploadImageForm.class),
                Image.find.all()
            ));
    }
    
    public static Result getImage(long id) {
        Image image = Image.find.byId(id);
        
        if (image != null) {
            
            /*** here happens the magic ***/
            return ok(image.data).as("image");
            /************************** ***/
            
        } else {
            flash("error", "Picture not found.");
            return redirect(routes.Application.index());
        }
    }
    
    public static Result uploadImage() {
        Form<UploadImageForm> form = form(UploadImageForm.class).bindFromRequest();
        
        if (form.hasErrors()) {
            return badRequest(index.render(
                    form,
                    Image.find.all()
                ));
            
        } else {
            new Image(
                    form.get().image.getFilename(),
                    form.get().image.getFile()
                );
            
            flash("success", "File uploaded.");
            return redirect(routes.Application.index());
        }
    }
    
    public static class UploadImageForm {
        public FilePart image;
        
        public String validate() {
            MultipartFormData data = request().body().asMultipartFormData();
            image = data.getFile("image");
            
            if (image == null) {
                return "File is missing.";
            }
            
            return null;
        }
    }
}
