package id.ac.polinema.intentexercise.Model;
import android.net.Uri;
import  android.os.Parcel;
import  android.os.Parcelable;
import android.widget.ImageView;

public class User implements Parcelable
{
    private String fullname,email,homepage,about;
    Uri pathImage;

    public User(String fullname, String email, String homepage, String about, Uri pathImage) {
        this.fullname = fullname;
        this.email = email;
        this.homepage = homepage;
        this.about = about;
        this.pathImage = pathImage;
    }

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getAbout() {
        return about;
    }

    public Uri getPathImage() {
        return pathImage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.fullname);
        dest.writeString(this.email);
        dest.writeString(this.homepage);
        dest.writeString(this.about);
        dest.writeParcelable(this.pathImage, flags);
    }

    protected User(Parcel in) {
        this.fullname = in.readString();
        this.email = in.readString();
        this.homepage = in.readString();
        this.about = in.readString();
        this.pathImage = in.readParcelable(Uri.class.getClassLoader());
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}