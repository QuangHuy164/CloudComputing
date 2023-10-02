import android.app.Dialog;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "FeedbackApp";
    private long startTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startTime = SystemClock.elapsedRealtime();

        // Initialize UI elements
        EditText firstNameEditText = findViewById(R.id.firstNameEditText);
        EditText lastNameEditText = findViewById(R.id.lastNameEditText);
        EditText phoneNumberEditText = findViewById(R.id.phoneNumberEditText);
        EditText commentEditText = findViewById(R.id.commentEditText);

        Button sendButton = findViewById(R.id.sendButton);
        Button resetButton = findViewById(R.id.resetButton);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long elapsedTime = SystemClock.elapsedRealtime() - startTime;
                Log.d(TAG, "Send Button Clicked (Elapsed Time: " + elapsedTime + "ms)");

                String firstName = firstNameEditText.getText().toString();
                String lastName = lastNameEditText.getText().toString();
                String phoneNumber = phoneNumberEditText.getText().toString();
                String comment = commentEditText.getText().toString();

                String feedbackMessage = "First Name: " + firstName + "\nLast Name: " + lastName
                        + "\nPhone Number: " + phoneNumber + "\nComment: " + comment;

                Toast.makeText(MainActivity.this, feedbackMessage, Toast.LENGTH_LONG).show();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long elapsedTime = SystemClock.elapsedRealtime() - startTime;
                Log.d(TAG, "Reset Button Clicked (Elapsed Time: " + elapsedTime + "ms)");

                // Clear text fields
                firstNameEditText.setText("");
                lastName