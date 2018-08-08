package company.my.lesson15;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // Виджет для показа списка
    ListView listView;
    // Массив для хранения заголовков
    List<String> items = new ArrayList<>(Arrays.asList("Тоҷикистон", "Ӯзбекистон", "Қирғизистон", "ИМА", "Қазоқистон"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Получение экземпляра ListView размещенного в макете
        listView = findViewById(R.id.list);

        // Объявление и инициализация экземпляра адаптера класса SimpleListAdapter
        // адаптер служит для соединения данных с виджетом для показа
        SampleListAdapter adapter = new SampleListAdapter(this, items);
        // привязать адаптер к ListView
        listView.setAdapter(adapter);
        // Указать обработчик кликов по элементам списка
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // Каждый раз при клике на какой-либо элемент вызывается функция onItemClick
            // и ей передаётся в качестве параметра корневой элемент макета, в данном случае LinearLayout
            // позиция выбранного элемента и id элемента
            // Через корневой элемент макета переданного через экземпляр класса View
            // можно получить ссылку к любому объекту в макете. Например, через их id.
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Получить ссылку на TextView в файле макета по id
                TextView textView = view.findViewById(R.id.text);
                // Показать сообщение с текстом TextView  из файла макета
                Toast.makeText(MainActivity.this, textView.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
