/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.customclasses;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.mvc.R;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

public class FileChooser {

    private Activity activity;
    private Item[] fileList;
    private File path;

    private boolean rootDir  = true; //check if the current directory is rootDir
    private boolean pickFile = true; //flag to get directory or file

    private String title = "";
    private String upTitle = "Up";
    private String positiveTitle = "Choose Path";
    private String negativeTitle = "Cancel";

    private ListAdapter adapter;
    private ArrayList<String> str = new ArrayList<>(); //Stores names of traversed directories, to detect rootDir
    private Listener listener;

    /**
     * @param pickFile true for file picker and false for directory picker
     * */
    public FileChooser(Activity activity, boolean pickFile, Listener fileChooserListener) {
        this.activity = activity;
        this.pickFile = pickFile;
        this.listener = fileChooserListener;
        title = pickFile ? "Choose File" : "Choose Directory";
        path = new File(String.valueOf(Environment.getExternalStorageDirectory()));
    }


    /**
     * The view of your file picker
     * */
    public void openDirectory() {
        loadFileList();
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, AlertDialog.THEME_DEVICE_DEFAULT_DARK);
        if (fileList == null)
            builder.create();

        builder.setTitle(title + "\n" + path.toString());
        builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int position) {
                String chosenFile = fileList[position].file;
                File selectedFile = new File(path + File.separator + chosenFile);

                if (selectedFile.isDirectory()) { // user click on folder
                    rootDir = false;
                    str.add(chosenFile); // Adds chosen directory to list
                    path = selectedFile;
                    openDirectory();
                }
                else if (chosenFile.equalsIgnoreCase(upTitle) && !selectedFile.exists()) { // 'up' was clicked
                    String s = str.remove(str.size() - 1); // present directory
                    path = new File(
                            path.toString().substring(0, path.toString().lastIndexOf(s))); // exclude present directory
                    if (str.isEmpty()) // no more directories in the list, rootDir
                        rootDir = true;
                    openDirectory();

                }
                else if (listener != null && pickFile)
                    listener.onSelectedPath(selectedFile.getAbsolutePath());

            }
        });

        if (!pickFile) {
            builder.setPositiveButton(positiveTitle, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (listener != null)
                        listener.onSelectedPath(path.getPath());
                }
            });
        }
        builder.setNegativeButton(negativeTitle, null);
        builder.show();
    }

    /**
     * Setup your file picker data
     * */
    private void loadFileList() {
        fileList = null;
        if (path.exists()) {
            FilenameFilter filter = new FilenameFilter() {
                @Override
                public boolean accept(File dir, String filename) {
                    File file = new File(dir, filename);
                    // Filters based on whether the file is hidden or not
                    return ((pickFile && file.isFile()) || file.isDirectory()) && !file.isHidden();
                }
            };

            String[] fList = path.list(filter); //set filter
            if (fList != null) {
                fileList = new Item[fList.length];
                for (int i = 0; i < fList.length; i++)
                    fileList[i] = new Item(fList[i], new File(path, fList[i]).isDirectory() ?
                            R.drawable.icon_balance : R.drawable.ic_refresh_black_24dp); //set icon, directory or file

                if (!rootDir) {
                    Item temp[] = new Item[fileList.length + 1];
                    System.arraycopy(fileList, 0, temp, 1, fileList.length);
                    temp[0] = new Item(upTitle, R.drawable.icons8_delete_30px);
                    fileList = temp;
                }
            }

        } else
            path = new File(String.valueOf(Environment.getExternalStorageDirectory()));

        try {
            adapter = new ArrayAdapter<Item>(activity,
                    android.R.layout.select_dialog_item, android.R.id.text1,
                    fileList) {
                @NonNull
                @Override
                public View getView(int position, View convertView, @NonNull ViewGroup parent) {
                    // creates view
                    View view = super.getView(position, convertView, parent);
                    TextView textView = view.findViewById(android.R.id.text1);
                    textView.setTextColor(Color.WHITE);

                    // put the image on the text view
                    textView.setCompoundDrawablesWithIntrinsicBounds(fileList[position].icon, 0, 0, 0);

                    // add margin between image and text (support various screen densities)
                    int dp5 = (int) (5 * activity.getResources().getDisplayMetrics().density + 0.5f);
                    textView.setCompoundDrawablePadding(dp5);

                    return view;
                }
            };
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class Item {
        public String file;
        public int icon;

        private Item(String file, Integer icon) {
            this.file = file;
            this.icon = icon;
        }

        @Override
        public String toString() {
            return file;
        }
    }

    public interface Listener {
        void onSelectedPath(String path);
    }

}