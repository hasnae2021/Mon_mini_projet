package com.example.mon_mini_projet;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CommandeActivity extends AppCompatActivity {
    private Spinner sp;
    private EditText nbr_de_sushis;
    private RadioButton p1,p2,p4,p6;
    private CheckBox boisson,sauces;
    private Button valider,submit;
    private TextView tv_resultat;
    DBmain dBmain;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commande);

        dBmain=new DBmain(CommandeActivity.this);
        findid();
        insertData();
        sp=findViewById(R.id.spinner);
        nbr_de_sushis=findViewById(R.id.nbr_sushi);
        p1=findViewById(R.id.p1);
        p2=findViewById(R.id.p2);
        p4=findViewById(R.id.p4);
        p6=findViewById(R.id.p6);
        boisson=findViewById(R.id.chec_boisson);
        valider=findViewById(R.id.btn_valider);
        sauces=findViewById(R.id.chec_sauce);
        tv_resultat=findViewById(R.id.result);
        //ajouter les valeurs dans le spinner
        List<String> ls= new ArrayList<String>();
        ls.add("sushi_saumon");
        ls.add("sushi_thon");
        ls.add("sushi_chesse");
        ls.add("sushi_crevettes");

        ls.add("sushi_avocat");
        ls.add("sushi_omlette");
        ls.add("sushi_surimi");

        ls.add("sushi_daurade");
        ls.add("sushi_maquereau");
        ls.add("sushi_anguille");

        ls.add("maki_chesse");
        ls.add("maki_concombre");

        ls.add("maki_saumon");
        ls.add("maki_thon");
        ls.add("maki_radis_jaune");
        ls.add("maki_avocat");
        ls.add("california_avocat_crevette");
        ls.add("california_avocat_saumon");
        ls.add("california_avocat_thon");
        ls.add("california_avocat_thon_cuit");
        ls.add("california_avocat_surimi");


        //Arryadapter
        ArrayAdapter<String> data=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,ls);
        sp.setAdapter(data);

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int v_sp=0;
                int nbr_per;
                int nbr_sushi;
                int sauce=0;
                int bois=0;
                int prix_total;
                //test le type de sushi selectionne
                if(sp.getSelectedItemId()==0)
                    v_sp=12;
                else
                if (sp.getSelectedItemId()==1)
                    v_sp=15;
                else
                if(sp.getSelectedItemId()==2)
                    v_sp=15;
                else
                     if (sp.getSelectedItemId()==3)
                         v_sp=12;
                else
                     if (sp.getSelectedItemId()==4)
                    v_sp=13;
                else
                     if (sp.getSelectedItemId()==5)
                    v_sp=16;
                else
                     if (sp.getSelectedItemId()==6)
                    v_sp=23;
                     else
                     if (sp.getSelectedItemId()==7)
                         v_sp=24;
                     else
                     if (sp.getSelectedItemId()==8)
                         v_sp=15;
                     else
                     if(sp.getSelectedItemId()==9)
                         v_sp=15;
                     else
                     if (sp.getSelectedItemId()==10)
                         v_sp=12;
                     else
                     if (sp.getSelectedItemId()==11)
                         v_sp=17;
                     else
                     if (sp.getSelectedItemId()==12)
                         v_sp=18;
                     else
                     if (sp.getSelectedItemId()==13)
                         v_sp=23;
                     else
                     if (sp.getSelectedItemId()==14)
                         v_sp=20;
                     else
                     if (sp.getSelectedItemId()==15)
                         v_sp=15;
                     else
                     if(sp.getSelectedItemId()==16)
                         v_sp=15;
                     else
                     if (sp.getSelectedItemId()==17)
                         v_sp=12;
                     else
                     if (sp.getSelectedItemId()==18)
                         v_sp=17;
                     else
                     if (sp.getSelectedItemId()==19)
                         v_sp=18;
                     else
                     if (sp.getSelectedItemId()==20)
                         v_sp=23;

                //test nombre de personnes
                if(p1.isChecked())
                    nbr_per=1;
                else
                if (p2.isChecked())
                    nbr_per=2;
                else
                if(p4.isChecked())
                    nbr_per=4;
                else
                    nbr_per=6;
                //test boisson ou sauce  est coche
                if(boisson.isChecked())
                    bois=6;
                if (sauces.isChecked())
                    sauce=10;

                nbr_sushi=Integer.parseInt(nbr_de_sushis.getText().toString());

                prix_total=v_sp * nbr_sushi * nbr_per +bois * nbr_per+ nbr_sushi* sauce;
                //affichage de resultat
                tv_resultat.setText("le prix total =" +prix_total+"DH");
            }
        });



    }

    private void insertData() {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqLiteDatabase =dBmain.getWritableDatabase();
                ContentValues contentValues=new ContentValues();
                if (boisson.isChecked())
                    contentValues.put("sub",boisson.getText().toString());
                if (sauces.isChecked())
                    contentValues.put("sub2",sauces.getText().toString());
                Long rec=sqLiteDatabase.insert("sushi",null,contentValues);
                if (rec!=null){
                    Toast.makeText(CommandeActivity.this, "Commande ajoutée avec succée ", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(CommandeActivity.this, "Commande Non ajoutée", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void findid() {

        valider=(Button)findViewById(R.id.btn_valider);
        submit=(Button)findViewById(R.id.submit);
        boisson=(CheckBox)findViewById(R.id.chec_boisson);
       sauces=(CheckBox)findViewById(R.id.chec_sauce);
        p1=(RadioButton) findViewById(R.id.p1);
        p2=(RadioButton) findViewById(R.id.p2);
        p4=(RadioButton) findViewById(R.id.p4);
        p6=(RadioButton) findViewById(R.id.p6);
        sp=(Spinner) findViewById(R.id.spinner);
        nbr_de_sushis=(EditText) findViewById(R.id.nbr_sushi);


    }
}