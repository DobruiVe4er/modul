package com.example.modul;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
// Предполагаемые классы CloudStorage, User и File
import com.example.modul.storage.CloudStorage;
import com.example.modul.user.User;
import com.example.modul.file.File;

public class MainActivity extends Activity {
    // Экземпляры классов для управления облачным хранилищем и пользователями
    private CloudStorage cloudStorage;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Инициализация облачного хранилища и пользователя
        cloudStorage = new CloudStorage();
        user = new User();
        // Пример использования методов
        try {
            File fileToUpload = new File("path_to_file");
            Log.d("MainActivity", "Загрузка файла: " + fileToUpload.getName());
            cloudStorage.uploadFile(fileToUpload);
            Log.d("MainActivity", "Файл загружен: " + fileToUpload.getName());

            String fileId = "file_id";
            Log.d("MainActivity", "Скачивание файла с ID: " + fileId);
            File downloadedFile = cloudStorage.downloadFile(fileId);
            Log.d("MainActivity", "Файл скачан: " + downloadedFile.getName());

            String userInfo = "user_info";
            Log.d("MainActivity", "Регистрация пользователя: " + userInfo);
            user.registerUser(userInfo);
            Log.d("MainActivity", "Пользователь зарегистрирован: " + userInfo);

            String userCredentials = "user_credentials";
            Log.d("MainActivity", "Вход пользователя: " + userCredentials);
            user.loginUser(userCredentials);
            Log.d("MainActivity", "Пользователь вошел: " + userCredentials);

            Log.d("MainActivity", "Поделиться файлом с ID: " + fileId + " с пользователем: " + user.getUsername());
            cloudStorage.shareFile(fileId, user);
            Log.d("MainActivity", "Файл поделен с пользователем: " + user.getUsername());

        } catch (Exception e) {
            Log.e("MainActivity", "Error: " + e.getMessage());
        }
    }
    // Дополнительные методы, если необходимо
}