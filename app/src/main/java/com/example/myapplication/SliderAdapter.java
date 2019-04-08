package com.example.myapplication;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import org.w3c.dom.Text;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;
    ImageView image;
    TextView name;
    TextView designaions;
    TextView qualification;
    TextView areaOfSpecification;
    TextView officialEmailId;

    public SliderAdapter(Context context)
    {
        this.context = context;
    }

    public int[] slide_images =
    {
            R.drawable.a01,
            R.drawable.a02,
            R.drawable.a03,
            R.drawable.f4,
            R.drawable.a05,
            R.drawable.a06,
            R.drawable.a07,
            R.drawable.a08,
    };

    public String[] names =
            {
                    "Dr. Priyesh Kanungo",
                    "Mr. Prashant P. Udawant",
                    "Sonia V. Relan",
                    "Ritesh Dhanare",
                    "Ms. Pratiksha L. Meshram",
                    "Mr. Piyush Kumar Soni",
                    "Mr. Pravinkummar B. Landge",
                    "Mr. Dhiraj V. Bhise"
            };

    public String[] designations =
            {
                    "Head of Information Technology Department",
                    "Assistant Professor",
                    "Assistant Professor",
                    "Assistant Professor",
                    "Assistant Professor",
                    "Assistant Professor",
                    "Assistant Professor",
                    "Assistant Professor",
            };

    public String[] qualifications =
            {
                  "Ph.D. (Computer Engg.),\n" +
                          "M.E. (Computer Engg.)\n" +
                          "B.E. (IndustrialandProduction Engg.),\n" +
                          "M.Phil (Computer Sc.)",
                    "Ph.D. Pursuing (Computer Engg.)\n" +
                            "M.E. (Computer Engg.)\n" +
                            "B.Tech (Computer Engg.)",
                    "M.Tech (Computer Engg.)\n" +
                            "B.E. (Computer Engg.)",
                    "M.E. (Computer Engg.)\n" +
                            "B.E. (Information Technology)",
                    "M.Tech (Computer Science & Engg.)\n" +
                            "B.Tech (Computer Technology)",
                    "M.E. (Computer Engg.)\n" +
                            "B.E. (Computer Science & Engg.)",
                    "M.E. (Computer Engg.)\n" +
                            "B.E. (Computer Science & Engg.)",
                    "M.E. (Computer Engg.)\n" +
                            "B.E. (Computer Science & Engg.)"
            };

    public String[] areaOfSpecifications =
            {
              "Distributed and Cloud Computing, Operating Systems, Artificial Intelligence etc.",
              "Machine Learning with Image Processing.",
              "Computer Network.",
              "Computer Engineering",
              "Data Warehousing and Data Mining",
              "Data Structures and Algorithms",
              "Data Structures and Algorithms, Intrusion Detection System",
              "Computer Programming, Data Mining, Web Mining, Human Computer Interaction"
            };

    public String[] officialEmailIds =
            {
              "priyesh.kanungo@nmims.edu",
                    "prashant.udawant@nmims.edu",
                    "sonia.relan@nmims.edu",
                    "ritesh.dhanare@nmims.edu",
                    "pratiksha.meshram@nmims.edu",
                    "piyushkumar.soni@nmims.edu",
                    "pravin.landge@nmims.edu",
                    "dhiraj.bhise@nmims.edu"
            };

    public int getCount() {
        return names.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    public Object instantiateItem(ViewGroup container, int position)
    {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView image = view.findViewById(R.id.image);
        TextView name = view.findViewById(R.id.name);
        TextView designation = view.findViewById(R.id.designations);
        TextView qualification = view.findViewById(R.id.qualifications);
        TextView areaOFSpecialisation = view.findViewById(R.id.areaOfSpecialisations);
        TextView officialEmailId = view.findViewById(R.id.officialEmailIds);

        image.setImageResource(slide_images[position]);
        name.setText(names[position]);
        designation.setText(designations[position]);
        qualification.setText(qualifications[position]);
        areaOFSpecialisation.setText(areaOfSpecifications[position]);
        officialEmailId.setText(officialEmailIds[position]);

        container.addView(view);

        return view;
    }

    public void destroyItem(ViewGroup container, int position ,Object object)
    {
        container.removeView((View) object);
    }

}
