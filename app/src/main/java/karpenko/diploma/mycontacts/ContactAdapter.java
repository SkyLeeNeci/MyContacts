package karpenko.diploma.mycontacts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import karpenko.diploma.mycontacts.databinding.ContactListItemBinding;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder>{

    private ArrayList<Contact> contactArrayList = new ArrayList<>();
    private MainActivity mainActivity;

    public ContactAdapter(ArrayList<Contact> contactArrayList, MainActivity mainActivity){
        this.contactArrayList = contactArrayList;
        this.mainActivity = mainActivity;
    }

    public void setContactArrayList(ArrayList<Contact> contactArrayList) {
        this.contactArrayList = contactArrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       /* View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_list_item, parent, false);
        return new ContactViewHolder(itemView);*/
        ContactListItemBinding contactListItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.contact_list_item,
                parent,
                false
        );
        return new ContactViewHolder(contactListItemBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {

        Contact contact = contactArrayList.get(position);/*
        holder.firsName.setText(contact.getFirstName());
        holder.lastName.setText(contact.getLastName());
        holder.email.setText(contact.getEmail());
        holder.phoneNumber.setText(contact.getPhoneNumber());*/
        holder.contactListItemBinding.setContact(contact);

        holder.itemView.setOnClickListener(view -> {
            mainActivity.addAndEditContact(true, contact, position);});


    }

    @Override
    public int getItemCount() {
        return contactArrayList.size();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder{

        /*private TextView firsName;
        private TextView lastName;
        private TextView email;
        private TextView phoneNumber;*/

        private ContactListItemBinding contactListItemBinding;

        public ContactViewHolder(@NonNull ContactListItemBinding contactListItemBinding) {
            super(contactListItemBinding.getRoot());

            this.contactListItemBinding = contactListItemBinding;
            /*firsName = itemView.findViewById(R.id.firstName);
            lastName = itemView.findViewById(R.id.lastName);
            email = itemView.findViewById(R.id.email);
            phoneNumber = itemView.findViewById(R.id.phoneNumber);*/

        }
    }

}
