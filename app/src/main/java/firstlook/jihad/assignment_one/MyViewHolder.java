package firstlook.jihad.assignment_one;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView nameView;
    public TextView teacherView;

    public MyViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView){
        super(itemView);

        imageView = itemView.findViewById(R.id.imageviewRecycler);
        nameView = itemView.findViewById(R.id.nameRecycler);
        teacherView = itemView.findViewById(R.id.teacherRecycler);

    }

}
