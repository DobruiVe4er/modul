package com.example.modul;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
// �������������� ������ CloudStorage, User � File
import com.example.modul.storage.CloudStorage;
import com.example.modul.user.User;
import com.example.modul.file.File;

public class MainActivity extends Activity {
    // ���������� ������� ��� ���������� �������� ���������� � ��������������
    private CloudStorage cloudStorage;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ������������� ��������� ��������� � ������������
        cloudStorage = new CloudStorage();
        user = new User();
        // ������ ������������� �������
        try {
            File fileToUpload = new File("path_to_file");
            Log.d("MainActivity", "�������� �����: " + fileToUpload.getName());
            cloudStorage.uploadFile(fileToUpload);
            Log.d("MainActivity", "���� ��������: " + fileToUpload.getName());

            String fileId = "file_id";
            Log.d("MainActivity", "���������� ����� � ID: " + fileId);
            File downloadedFile = cloudStorage.downloadFile(fileId);
            Log.d("MainActivity", "���� ������: " + downloadedFile.getName());

            String userInfo = "user_info";
            Log.d("MainActivity", "����������� ������������: " + userInfo);
            user.registerUser(userInfo);
            Log.d("MainActivity", "������������ ���������������: " + userInfo);

            String userCredentials = "user_credentials";
            Log.d("MainActivity", "���� ������������: " + userCredentials);
            user.loginUser(userCredentials);
            Log.d("MainActivity", "������������ �����: " + userCredentials);

            Log.d("MainActivity", "���������� ������ � ID: " + fileId + " � �������������: " + user.getUsername());
            cloudStorage.shareFile(fileId, user);
            Log.d("MainActivity", "���� ������� � �������������: " + user.getUsername());

        } catch (Exception e) {
            Log.e("MainActivity", "Error: " + e.getMessage());
        }
    }
    // �������������� ������, ���� ����������
}