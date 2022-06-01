package com.example.musicplayerlite.dialogs;

import android.content.Context;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.musicplayerlite.R;
import com.example.musicplayerlite.model.Music;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class SongOptionDialog extends BottomSheetDialog {

    public SongOptionDialog(@NonNull Context context, Music music) {
        super(context);
        setContentView(R.layout.dialog_option);

        TextView option = findViewById(R.id.add_to_playlist);
        assert option != null;
        option.setOnClickListener(v ->
                showPlaylistDialog(music));
    }

    private void showPlaylistDialog(Music music) {
        PlaylistHandlerDialog dialog = new PlaylistHandlerDialog(getContext(), music);
        dismiss();
        dialog.show();
    }
}
