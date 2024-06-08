package manuel.ortega.validaciones_manuel

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txtNombre=findViewById<TextView>(R.id.txtNombre)
        val txtCorreo=findViewById<TextView>(R.id.txtCorreo)
        val txtClave=findViewById<TextView>(R.id.txtClave)
        val txtEdad = findViewById<TextView>(R.id.txtEdad)
        val txtDui = findViewById<TextView>(R.id.TxtDui)
        val btnAgregar=findViewById<Button>(R.id.btnAgreagr)

        btnAgregar.setOnClickListener {
            if (txtNombre.text.isEmpty() || txtCorreo.text.isEmpty()||txtClave.text.isEmpty() || txtEdad.text.isEmpty()||txtDui.text.isEmpty()){
                Toast.makeText(this,"Ingrese todos los datos ",Toast.LENGTH_SHORT).show()
            }else {
            if (!txtEdad.text.matches("[0-9]".toRegex())){
                Toast.makeText(this,"Edad invalida",Toast.LENGTH_SHORT).show()
            }else{
                if (!txtCorreo.text.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]".toRegex())){
                    Toast.makeText(this,"Ingrese correo valido",Toast.LENGTH_SHORT).show()
                }else{
                    if (txtClave.text.length<6 || txtClave.text.matches("[0-9]+".toRegex())){
                        Toast.makeText(this,"La clave debe contener al menos 6 caracteres",Toast.LENGTH_SHORT).show()
                    }else{
                        if (txtDui.text.length!=9 || !txtDui.text.matches("[0-9]+-[0-9]".toRegex())){
                            Toast.makeText(this,"Ingrese DUI valido ",Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
            }
            }
        }
    }
