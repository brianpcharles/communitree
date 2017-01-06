package com.brianpcharles.communitree;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.brianpcharles.communitree.models.Gallery;
import com.brianpcharles.communitree.models.Listing;
import com.brianpcharles.communitree.models.Location;
import com.brianpcharles.communitree.models.SessionManager;
import com.brianpcharles.communitree.models.Status;
import com.brianpcharles.communitree.models.User;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmList;

public class MainActivity extends AppCompatActivity {

    private Realm realm;
    private SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        session = new SessionManager(this.getApplicationContext());

        init();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        session.logout();
    }

    public void init() {
        realm = Realm.getDefaultInstance();

        // Delete all persons
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.delete(com.brianpcharles.communitree.models.Image.class);
                realm.delete(com.brianpcharles.communitree.models.Gallery.class);
                realm.delete(com.brianpcharles.communitree.models.Listing.class);
                realm.delete(com.brianpcharles.communitree.models.Location.class);
                realm.delete(com.brianpcharles.communitree.models.Promotion.class);
                realm.delete(com.brianpcharles.communitree.models.Coupon.class);
                realm.delete(com.brianpcharles.communitree.models.Event.class);
                realm.delete(com.brianpcharles.communitree.models.User.class);
                realm.delete(com.brianpcharles.communitree.models.UserListing.class);
            }
        });

        //a user
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                User user = realm.createObject(User.class, UUID.randomUUID().toString());
                user.setName("Brian Charles");
                user.setAdmin(true);
                user.setEmail("eppingjetta@gmail.com");
                user.setIsActive(Status.ACTIVE.ordinal());
                user.setPassword("Radiohead1");
            }
        });
        final User user = realm.where(User.class).findFirst();
        session.login(user);

        //an image
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                // Add a person
                com.brianpcharles.communitree.models.Image image = realm.createObject(com.brianpcharles.communitree.models.Image.class, UUID.randomUUID().toString());
                image.setWidth(534);
                image.setHeight(401);
                image.setName("Taco Bell 1");
                image.setCrop_x(0);
                image.setCrop_y(0);
                image.setUrl("http://www.gannett-cdn.com/-mm-/59855003ce8ae1e82e79ac1e958123e71ab3ab3c/c=222-0-3116-2176&r=x404&c=534x401/local/-/media/2016/07/13/USATODAY/USATODAY/636040014241536634-AP-Earns-Yum-Brands.jpg");
            }
        });

        final com.brianpcharles.communitree.models.Image image = realm.where(com.brianpcharles.communitree.models.Image.class).findFirst();
        System.out.println(image.getName());

        //a gallery
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Gallery g = realm.createObject(Gallery.class, UUID.randomUUID().toString());
                g.setName("Test Gallery 1");
                g.setImages(new RealmList<com.brianpcharles.communitree.models.Image>(image));
            }
        });
        final Gallery gallery = realm.where(Gallery.class).findFirst();
        System.out.println(gallery.getName() + " has " + gallery.getImages().size() + " images");

        //a location
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Location location = realm.createObject(Location.class, UUID.randomUUID().toString());
                location.setAddress_1("6 Wilson St.");
                location.setCity("Somersworth");
                location.setState("NH");
                location.setZip_code("03878");
            }
        });
        final Location location = realm.where(Location.class).findFirst();
        System.out.println(location.getFormattedAddress());

        //a listing
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Listing listing = realm.createObject(Listing.class, UUID.randomUUID().toString());
                listing.setIsActive(Status.ACTIVE.ordinal());
                listing.setName("A New Business");
                listing.setEmail("eppingjetta@gmail.com");
                listing.setLocation(location);
                listing.setPrimaryPhone("603-866-6412");
                listing.setGallery(gallery);
                listing.setWebsite("http://www.google.com");
                listing.setTimezone("America/New_York");
            }
        });
        final Listing listing = realm.where(Listing.class).findFirst();
        System.out.println(listing.getLocation().getFormattedAddress());
    }
}
