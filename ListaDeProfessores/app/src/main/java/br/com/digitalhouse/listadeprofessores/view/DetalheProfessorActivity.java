package br.com.digitalhouse.listadeprofessores.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.digitalhouse.listadeprofessores.R;
import br.com.digitalhouse.listadeprofessores.model.Professor;
import de.hdodenhof.circleimageview.CircleImageView;

public class DetalheProfessorActivity extends AppCompatActivity {
    private TextView textViewNome;
    private TextView textViewCurso;
    private TextView textViewCurriculum;
    private CircleImageView circleProfessor;
    private ImageView imageViewBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_professor);

        if (getIntent() != null && getIntent().getExtras() != null){
            Professor professor = getIntent().getParcelableExtra("PROFESSOR");

            if(professor != null){
                textViewNome = findViewById(R.id.textViewProfessor);
                textViewNome.setText(professor.getNome());
                textViewCurso = findViewById(R.id.textViewCurso);
                textViewCurso.setText(professor.getCurso());
                textViewCurriculum = findViewById(R.id.textViewCurriculum);
                textViewCurriculum.setText(professor.getCurriculum());
                circleProfessor = findViewById(R.id.circleImageViewProfessor);
                circleProfessor.setImageResource(professor.getFoto());
            }
        }

        imageViewBack = findViewById(R.id.imageViewBack);
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
