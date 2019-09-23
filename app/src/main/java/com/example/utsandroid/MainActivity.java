package com.example.utsandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    EditText firstname, lastname, address, phone;
    Spinner spinner1;
    CheckBox cb_smk_dwi, cb_smk_don, cb_smk_merah_putih, cb_smu_sutar;
    RadioGroup sekolah_radiogroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lastname = findViewById(R.id.lastname);
        firstname = findViewById(R.id.firstname);
        address = findViewById(R.id.address);
        phone = findViewById(R.id.phone);
        cb_smk_dwi = findViewById(R.id.cb_smk_dwi);
        cb_smk_don = findViewById(R.id.cb_smk_don);
        cb_smk_merah_putih = findViewById(R.id.cb_smk_merah_putih);
        cb_smu_sutar = findViewById(R.id.cb_smu_sutar);
        sekolah_radiogroup = findViewById(R.id.sekolah_radiogroup);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater MenuInflater = getMenuInflater();
        MenuInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mn_snack_simpan:
                String nama_awal,nama_akhir;

                nama_awal = firstname.getText().toString();
                nama_akhir = lastname.getText().toString();

                Intent i = new Intent(MainActivity.this,get_show_intent.class);
                i.putExtra("i_nama_awal", nama_awal);
                i.putExtra("i_nama_akhir", nama_akhir);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(i);
                return true;

            case R.id.mn_snack_kosong:
                firstname.getText().clear();
                lastname.getText().clear();
                address.getText().clear();
                phone.getText().clear();
                return true;

            case R.id.mn_snack_biodata:
                View view = findViewById(R.id.main_activity_pertama);
                String pesan = "SAHRUL RAMDHANI";
                int durasi = Snackbar.LENGTH_SHORT;
                Snackbar.make(view,pesan,durasi).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

}
