package com.example.profile_people_mvvm;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> implements Filterable {
    private List<Note> notes = new ArrayList<>();
    private List<Note> notesfull = new ArrayList<>(notes);


    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.note_item,parent,false);
        return  new NoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {

        Note currentNote = notes.get(position);
        holder.textViewTitle.setText(currentNote.getTitle());
        holder.textViewDescription.setText(currentNote.getDescription());
        holder.textViewPriority.setText(String.valueOf(currentNote.getPriority()));

    }

    @Override
    public int getItemCount() {
        return notes.size();

    }

    public void  setNotes(List<Note> notes){
        this.notes = notes;
        notifyDataSetChanged();

    }

    public Note getNoteAt(int position){
        return  notes.get(position);
    }

    //Implementing SearchBar

    //this is the function that is called in MainActivity
    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    //Using Filter which has two functions FilterResults and PublishResults
    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<Note> filteredList = new ArrayList<>();

            if(charSequence == null || charSequence.length() == 0){
//                Log.d("TAG_Adapter", "INIFonCheckingResults:"+charSequence);
                filteredList.addAll(notesfull);
            }
            else {
                String filterPattern = charSequence.toString().toLowerCase().trim();

                Log.d("TAG_Adapter", "INELSEonCheckingResults:"+notes);
                for(Note note :notesfull){
                    if(note.getTitle().toLowerCase().contains(filterPattern)){
//                        Log.d("TAG_Adapter", "INELSEonCheckingResults:"+notes);
                        filteredList.add(note);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
//            notes.clear();
            notes.addAll((List)filterResults.values);
            notifyDataSetChanged();
        }
    };





//    NoteAdapter(List<Note> notes){
//    this.notes = notes;
//    notesfull = new ArrayList<>(notes);
//    }




    class NoteHolder extends RecyclerView.ViewHolder{
        private TextView textViewTitle;
        private TextView textViewDescription;
        private TextView textViewPriority;

        public NoteHolder(View itemView){
            super(itemView);
            textViewTitle =itemView.findViewById(R.id.text_view_title);
            textViewDescription = itemView.findViewById(R.id.text_view_description);
            textViewPriority =itemView.findViewById(R.id.text_view_priority);


        }
    }
}
