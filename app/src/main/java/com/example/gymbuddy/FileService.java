//package com.example.gymbuddy;
//
//import android.util.Log;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.nio.charset.StandardCharsets;
//
//public class FileService {
//    public User readUserFromFile(InputStream path) throws IOException, JSONException {
//        try {
//            BufferedReader reader = new BufferedReader(
//                    new InputStreamReader(path, StandardCharsets.UTF_8));
//
//            StringBuilder stringBuilder = new StringBuilder();
//            String line = reader.readLine();
//            while (line != null) {
//                stringBuilder.append(line).append("\n");
//                line = reader.readLine();
//            }
//            reader.close();
//// This response will have Json Format String
//            String response = stringBuilder.toString();
//
//            JSONObject userJson = new JSONObject(response);
////Java Object
//            User user =
//                    new User(userJson.get("firstName").toString(),
//                            userJson.get("lastName").toString(),
//                            userJson.get("email").toString(),
//                            userJson.get("username").toString(),
//                            userJson.get("password").toString());
//            Log.d("FileService", user.toString());
//            return user;
//        } catch (IOException | JSONException e) {
//            Log.e("Exception", "File read failed: " + e.toString());
//            throw e;
//        }
//    }
//
//    public void writeUserToFile(User user) throws JSONException {
//        JSONObject userJson = new JSONObject();
//        userJson.put("firstName", user.firstName);
//        userJson.put("lastName", user.lastName);
//        userJson.put("email", user.email);
//        userJson.put("username", user.username);
//        userJson.put("password", user.password);
//
//        // Convert JsonObject to String Format
//        String userString = userJson.toString();
//    }
//}
