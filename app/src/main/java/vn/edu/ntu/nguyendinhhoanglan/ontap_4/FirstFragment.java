package vn.edu.ntu.nguyendinhhoanglan.ontap_4;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import java.util.Calendar;
import java.util.List;

import vn.edu.ntu.nguyendinhhoanglan.controller.INgoaiTeController;
import vn.edu.ntu.nguyendinhhoanglan.model.NgoaiTe;

public class FirstFragment extends Fragment {
    List<String> arr;
    NavController navController;
    ImageView imvDate;
    EditText edtDate, edtBuy, edtSell;
    RadioGroup rdgType;
    Button btnAdd;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_first, container, false);
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        addViews(v);
        return v;
    }
    private void addViews(View v) {
        navController = NavHostFragment.findNavController(FirstFragment.this);
        arr = ((MainActivity)getActivity()).arr;
        ((MainActivity)getActivity()).navController = navController;
        imvDate = v.findViewById(R.id.imvDate);
        edtDate = v.findViewById(R.id.edtDate);
        edtBuy = v.findViewById(R.id.edtBuy);
        edtSell = v.findViewById(R.id.edtSell);
        rdgType = v.findViewById(R.id.rdgType);
        btnAdd = v.findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();
            }
        });

        imvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        StringBuilder builder = new StringBuilder();
                        builder.append(dayOfMonth)
                                .append("/")
                                .append(++month)
                                .append("/")
                                .append(year);
                        edtDate.setText(builder.toString());
                    }
                };
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                        listener,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                );
                datePickerDialog.show();
            }
        });
    }

    private void addItem(){
        RadioButton rdBtn = getActivity().findViewById(rdgType.getCheckedRadioButtonId());
        if (edtDate.getText().length() <= 0 ||
                edtBuy.getText().length() <=0 ||
                edtSell.getText().length() <= 0){
            Toast.makeText(getActivity(), "Giá trị không hợp lệ", Toast.LENGTH_SHORT).show();
        }
        else{
            StringBuilder b = new StringBuilder();
            b.append(edtDate.getText().toString()).append("\n")
                    .append(rdBtn.getText().toString()).append("\n")
                    .append("Mua vào: ").append(edtBuy.getText().toString())
                    .append("   Bán ra: ").append(edtSell.getText().toString());
            arr.add(b.toString());
        }

    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }
}